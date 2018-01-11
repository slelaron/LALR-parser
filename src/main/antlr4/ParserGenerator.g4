grammar ParserGenerator;

@header {
    import java.util.*;
    import java.util.stream.Collectors;
}

@parser::members {
    private final Map<String, Wrapper<String>> elements = new HashMap<>();
    private final Set<String> terminals = new HashSet<>();
    private final List<Rule> rules = new ArrayList<>();

    private class Wrapper<T> {
        private final String name;
        private final T element;

        Wrapper(String name, T element) {
            this.name = name;
            this.element = element;
        }

        String getName() {
            return name;
        }

        T getElement() {
            return element;
        }
    }
}

gram returns [String pText]
locals [StringBuilder builder = new StringBuilder()]
@after {
    StringBuilder builder1 = new StringBuilder();
    for (Map.Entry<String, Wrapper<String>> entry: elements.entrySet()) {
        builder1.append("        ");
        builder1.append(entry.getValue().getElement());
        builder1.append('\n');
    }
    builder1.append("        List<Rule> ______rules = new ArrayList<>();\n");
    builder1.append($builder);
    System.err.println(rules);
    try {
        ControlTable controlTable = new ControlTable(new NonTerminal("start"), rules);
        ControlTable.Wrapper<Element, SuperState<State>> wrapper = controlTable.getTable();
        builder1.append("        int[][] ______table = new int[][] ");
        builder1.append(wrapper.getTable());
        builder1.append(";\n");
        String string = wrapper.getElements().stream().map(a -> '"' + a.getName() + '"').collect(Collectors.toList()).toString();
        builder1.append("        String[] ______names = new String[] ");
        builder1.append("{" + string.substring(1, string.length() - 1) + "};\n");
    } catch (GeneratorException e) {
        e.printStackTrace();
    }
    builder1.append("        List<Terminal> ______terminals = Arrays.asList(");
    Iterator<String> iterator = terminals.iterator();
    while (iterator.hasNext()) {
        String cur = iterator.next();
        builder1.append(cur);
        if (iterator.hasNext()) {
            builder1.append(", ");
        }
    }
    builder1.append(");\n");
    $pText = builder1.toString();
}
:
    ((nonterm_rule {
        $builder.append($nonterm_rule.pText);
    }| term_rule) ';')*;

nonterm_rule returns [String pText]
locals [StringBuilder builder = new StringBuilder()]
@after {
    $pText = $builder.toString();
}
:
    NNAME {
        elements.put($NNAME.text, new Wrapper($NNAME.text, "NonTerminal " + $NNAME.text + " = new NonTerminal(\"" + $NNAME.text + "\");"));
    } ':' (subrule '|' {
        $builder.append("        ______rules.add(new Rule(" + $NNAME.text + ", Arrays.asList(");
        for (int i = 0; i < $subrule.textList.size(); i++) {
            $builder.append($subrule.textList.get(i).getName());
            if (i != $subrule.textList.size() - 1) {
                $builder.append(", ");
            }
        }
        $builder.append(")));\n");
        rules.add(new Rule(new NonTerminal($NNAME.text), $subrule.textList.stream().map(Wrapper<Element>::getElement).collect(Collectors.toList())));
    })* subrule {
        $builder.append("        ______rules.add(new Rule(" + $NNAME.text + ", Arrays.asList(");
        for (int i = 0; i < $subrule.textList.size(); i++) {
            $builder.append($subrule.textList.get(i).getName());
            if (i != $subrule.textList.size() - 1) {
                $builder.append(", ");
            }
        }
        $builder.append(")));\n");
        rules.add(new Rule(new NonTerminal($NNAME.text), $subrule.textList.stream().map(Wrapper<Element>::getElement).collect(Collectors.toList())));
    };


term_rule
locals [boolean needToSkip = false]
:
    TNAME ':' TEXT ('->' NNAME {if ($NNAME.text.equals("skip")) {$needToSkip = true;}})? {
        String pattern = $TEXT.text.substring(1, $TEXT.text.length() - 1);
        elements.put($TNAME.text, new Wrapper<String>($TNAME.text, "Terminal " + $TNAME.text + " = new Terminal(\"" + $TNAME.text +
         "\", \"" + pattern + "\", " +
          ($needToSkip ? "true" : "false") + ");"));
        terminals.add($TNAME.text);
    };

subrule returns [List<Wrapper<Element>> textList]
@init {
    $textList = new ArrayList<Wrapper<Element>>();
}
:
    (TNAME {
        String name = $TNAME.text;
        $textList.add(new Wrapper($TNAME.text, new Terminal($TNAME.text, "", false)));
        terminals.add($TNAME.text);
    }| NNAME {
        $textList.add(new Wrapper($NNAME.text, new NonTerminal($NNAME.text)));
    }| TEXT {
        String name = $TEXT.text.substring(1, $TEXT.text.length() - 1);
        String realName = Terminal.getName("PRODUCED");
        if (!elements.containsKey($TEXT.text)) {
            elements.put($TEXT.text, new Wrapper<String>(realName, "Terminal " + realName + " = new Terminal(\"" + name + "\", \"" + name + "\", false);"));
            terminals.add(realName);
        } else {
            realName = elements.get($TEXT.text).getName();
        }
        $textList.add(new Wrapper(realName, new Terminal(name, "", false)));
    })+
    |;

NNAME: [a-z][a-zA-Z0-9_]*;
TNAME: [A-Z][a-zA-Z0-9_]*;
TEXT: '\'\''|('\''.*?~('\\')'\'');
WS: [ \n\t]+ -> skip;