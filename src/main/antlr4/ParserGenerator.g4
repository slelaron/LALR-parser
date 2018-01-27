grammar ParserGenerator;

@header {
    import java.util.*;
    import java.util.stream.Collectors;
}

@parser::members {
    List<Pair<String, Integer>> nonTerminals = new ArrayList<>();
    List<Pair<String, Pair<String, Boolean>>> terminals = new ArrayList<>();
    Map<String, String> inContext = new HashMap<>();
    Map<String, Element> elements = new HashMap<>();
    List<Pair<String, List<Pair<String, String>>>> rules = new ArrayList<>();
    Map <String, Map<String, Pair<String, Integer>>> params = new HashMap<>();
    Map <String, Map<String, Pair<String, Integer>>> rets = new HashMap<>();
    Map <String, Map<String, Pair<String, Integer>>> locals = new HashMap<>();
}

gram returns [String parserText, String headerText, String membersText]
@init {
    $headerText = "";
    $membersText = "";
}
@after {
    GenerateAttributes gen = new GenerateAttributes();
    rules.stream().forEach(a -> gen.resolve(a.second(), a.first(), params, rets, locals.get(a.first())));
    List<Rule> r = rules.stream().map(b -> new Rule(new NonTerminal(b.first()), b.second().stream().map(a -> elements.get(a.first())).collect(Collectors.toList()))).collect(Collectors.toList());
    //r.stream().forEach(System.err::println);
    StringBuilder builder = new StringBuilder();
    nonTerminals.stream().forEach(a -> {
        builder.append("        ");
        builder.append("NonTerminal ");
        builder.append(a.first());
        builder.append(" = new NonTerminal(\"");
        builder.append(a.first());
        builder.append("\", (___objects, ___elements) -> {");
        builder.append(gen.getResult().get(a.first()));
        builder.append("}, ");
        builder.append(a.second());
        builder.append(");\n");
    });

    terminals.stream().forEach(a -> {
        builder.append("        ");
        builder.append("Terminal ");
        builder.append(a.first());
        builder.append(" = new Terminal(\"");
        builder.append(a.first());
        builder.append("\", \"");
        builder.append(a.second().first());
        builder.append("\", ");
        builder.append(a.second().second());
        builder.append(");\n");
    });

    inContext.entrySet().stream().forEach(a -> {
        builder.append("        ");
        builder.append("Terminal ");
        builder.append(a.getValue());
        builder.append(" = new Terminal(\"");
        builder.append(a.getKey());
        builder.append("\", \"");
        builder.append(a.getKey());
        builder.append("\", ");
        builder.append("false);\n");
    });

    builder.append("        List<Rule> ___rules = new ArrayList<>();\n");

    try {
        ControlTable controlTable = new ControlTable(new NonTerminal("start"), r);
        ControlTable.Wrapper<Element, SuperState<State>> wrapper = controlTable.getTable();
        //wrapper.getSuperStates().forEach(System.err::println);
        builder.append("        int[][] ___table = new int[][] ");
        builder.append(wrapper.getTable());
        builder.append(";\n");
        String string = wrapper.getElements().stream().map(a -> '"' + a.getName() + '"').collect(Collectors.toList()).toString();
        builder.append("        String[] ___names = new String[] ");
        builder.append("{" + string.substring(1, string.length() - 1) + "};\n");
    } catch (GeneratorException e) {
        e.printStackTrace();
        throw new NullPointerException();
    }

    rules.stream().forEach(a -> {
        builder.append("        ");
        builder.append("___rules.add(new Rule(");
        builder.append(a.first());
        builder.append(", ");
        if (a.second().isEmpty()) {
            builder.append("Collections.emptyList(");
        } else if (a.second().size() == 1) {
            builder.append("Collections.singletonList(");
        } else {
            builder.append("Arrays.asList(");
        }
        Iterator<Pair<String, String>> iterator = a.second().iterator();
        while (iterator.hasNext()) {
            builder.append(iterator.next().first());
            if (iterator.hasNext()) {
                builder.append(", ");
            }
        }
        builder.append(")));\n");
    });

    builder.append("        List<Terminal> ___terminals = Arrays.asList(");
    Iterator<Map.Entry<String, String>> mapIterator = inContext.entrySet().iterator();
    while (mapIterator.hasNext()) {
        String cur = mapIterator.next().getValue();
        builder.append(cur);
        builder.append(", ");
    }
    Iterator<Pair<String, Pair<String, Boolean>>> iterator = terminals.iterator();
    while (iterator.hasNext()) {
        String cur = iterator.next().first();
        builder.append(cur);
        if (iterator.hasNext()) {
            builder.append(", ");
        }
    }
    builder.append(");\n");
    $parserText = builder.toString();

}
:
    ('@header' ATTRIBUTES {
        $headerText = $ATTRIBUTES.text.substring(1, $ATTRIBUTES.text.length() - 1);
    })?
    ('@members' ATTRIBUTES {
        $membersText = $ATTRIBUTES.text.substring(1, $ATTRIBUTES.text.length() - 1);
    })?
    ((nonterm_rule | term_rule) ';')*;

nonterm_rule
locals [List<Pair<String, String>> attributes = new ArrayList<>(), int border = 0,
        List<Pair<String, String>> local = new ArrayList<>(), int index = 1, List<Pair<String, String>> names = new ArrayList<>()]
:
    name=NNAME
    ('[' (TNAME NNAME {$attributes.add(new Pair<>($TNAME.text, $NNAME.text));} ',')* (TNAME NNAME {$attributes.add(new Pair<>($TNAME.text, $NNAME.text));}) ']' {
        Map<String, Pair<String, Integer>> map = new HashMap<>();
        for (Pair<String, String> pair: $attributes) {
            map.put(pair.second(), new Pair<>(pair.first(), $index++));
        }
        params.put($name.text, map);
        $attributes.clear();
    })?
    ('returns' '[' (TNAME NNAME {$attributes.add(new Pair<>($TNAME.text, $NNAME.text));} ',')* (TNAME NNAME {$attributes.add(new Pair<>($TNAME.text, $NNAME.text));}) ']' {
        Map<String, Pair<String, Integer>> map = new HashMap<>();
        int lBorder = $index;
        for (Pair<String, String> pair: $attributes) {
            map.put(pair.second(), new Pair<>(pair.first(), $index++));
        }
        $border = $index - lBorder;
        rets.put($name.text, map);
        $local.addAll($attributes);
        $attributes.clear();
    })?
    ('locals' '[' (TNAME NNAME {$attributes.add(new Pair<>($TNAME.text, $NNAME.text));} ',')* (TNAME NNAME {$attributes.add(new Pair<>($TNAME.text, $NNAME.text));}) ']' {
        Map<String, Pair<String, Integer>> map = new HashMap<>();
        for (Pair<String, String> pair: $attributes) {
            map.put(pair.second(), new Pair<>(pair.first(), $index++));
        }
        locals.put($name.text, map);
        $local.addAll($attributes);
        $attributes.clear();
    })? ':' {
        if (!$local.isEmpty()) {
            String curName = Terminal.generateName("LOCALS");
            StringBuilder builder = new StringBuilder();
            for (Pair<String, String> pair: $local) {
                 builder.append("___objects.add(new Wrapper<");
                 builder.append(pair.first());
                 builder.append(">());");
            }
            $names.add(new Pair<>(curName, builder.toString()));
            elements.put(curName, new NonTerminal(curName));
            nonTerminals.add(new Pair<>(curName, 0));
            rules.add(new Pair<>(curName, Collections.emptyList()));
        }
        nonTerminals.add(new Pair<>($name.text, $border));
        elements.put($name.text, new NonTerminal($name.text));
    }
    (subrule[$name.text, new ArrayList<Pair<String, String>>($names)] '|')* subrule[$name.text, new ArrayList<Pair<String, String>>($names)];


term_rule
locals [boolean skip = false]
:
    TNAME ':' TEXT ('->' NNAME {if ($NNAME.text.equals("skip")) {$skip = true;}})? {
        String curText = $TEXT.text.substring(1, $TEXT.text.length() - 1);
        terminals.add(new Pair<>($TNAME.text, new Pair<>(curText, $skip)));
        elements.put($TNAME.text, new Terminal($TNAME.text, "", $skip));
    };

subrule[String nonTermName, List<Pair<String, String>> names]
locals [List<String> attributes = new ArrayList<>()]
:
    ((TNAME {
        $names.add(new Pair<>($TNAME.text, ""));
    }
    | name=NNAME ('[' ('$' NNAME {$attributes.add($NNAME.text);}
            ('.' NNAME {$attributes.set($attributes.size() - 1, $attributes.get($attributes.size() - 1) + "." + $NNAME.text);})* ',')*
            '$' NNAME {$attributes.add($NNAME.text);}
            ('.' NNAME {$attributes.set($attributes.size() - 1, $attributes.get($attributes.size() - 1) + "." + $NNAME.text);})* ']')? {
        if (!$attributes.isEmpty()) {
            String curName = Terminal.generateName("MARKER");
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < $attributes.size(); i++) {
                builder.append("___objects.add(new Wrapper<>($");
                builder.append($attributes.get(i));
                builder.append("));");
            }
            $names.add(new Pair<>(curName, builder.toString()));
            elements.put(curName, new NonTerminal(curName));
            nonTerminals.add(new Pair<>(curName, 0));
            rules.add(new Pair<>(curName, Collections.emptyList()));
        }
        $attributes.clear();
        $names.add(new Pair<>($name.text, ""));
    }
    | ATTRIBUTES {
        String curName = Terminal.generateName("ATTRIBUTE");
        rules.add(new Pair<>(curName, Collections.emptyList()));
        elements.put(curName, new NonTerminal(curName));
        nonTerminals.add(new Pair<>(curName, 0));
        $names.add(new Pair<>(curName, $ATTRIBUTES.text.substring(1, $ATTRIBUTES.text.length() - 1)));
    }
    | TEXT {
        String curName = Terminal.generateName("PRODUCED");
        String curText = $TEXT.text.substring(1, $TEXT.text.length() - 1);
        if (inContext.containsKey(curText)) {
            curName = inContext.get(curText);
        } else {
            inContext.put(curText, curName);
            elements.put(curName, new Terminal(curText, "", false));
        }
        $names.add(new Pair<>(curName, ""));
    })+
    | ) {
        rules.add(new Pair<>(nonTermName, $names));
    };

NNAME: [a-z][a-zA-Z0-9_]*;
TNAME: [A-Z][a-zA-Z0-9_]*;
TEXT: '"'(.*?~('\\'))?('\\\\')*'"';
ATTRIBUTES: '\''(.*?~('\\'))?('\\\\')*'\'';
WS: [ \n\t]+ -> skip;