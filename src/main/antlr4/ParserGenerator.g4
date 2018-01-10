grammar ParserGenerator;

@header {
    import java.util.*;
    import java.util.stream.Collectors;
}

@parser::members {
    private final Set<String> elements = new HashSet<>();
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

    private void addElement(String string) {
        elements.add(string);
    }
}

gram returns [String pText]
locals [StringBuilder builder = new StringBuilder()]
@after {
    StringBuilder builder1 = new StringBuilder();
    for (String element: elements) {
        builder1.append("        ");
        builder1.append(element);
        builder1.append('\n');
    }
    builder1.append("        List<Rule> rules = new ArrayList<>();\n");
    builder1.append($builder);
    try {
        ControlTable controlTable = new ControlTable(new NonTerminal("start"), rules);
        ControlTable.Wrapper<Element, SuperState<State>> wrapper = controlTable.getTable();
        builder1.append("        int[][] table = new int[][] ");
        builder1.append(wrapper.getTable());
        builder1.append(";\n");
        String string = wrapper.getElements().stream().map(a -> '"' + a.getName() + '"').collect(Collectors.toList()).toString();
        builder1.append("        String[] names = new String[] ");
        builder1.append("{" + string.substring(1, string.length() - 1) + "};\n");
    } catch (GeneratorException e) {
        e.printStackTrace();
    }
    builder1.append("        List<Terminal> terminals = Arrays.asList(");
    Iterator<String> iterator = terminals.iterator();
    while (iterator.hasNext()) {
        builder1.append(iterator.next());
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
        addElement("NonTerminal " + $NNAME.text + " = new NonTerminal(\"" + $NNAME.text + "\");");
    } ':' (subrule '|' {
        $builder.append("        rules.add(new Rule(" + $NNAME.text + ", Arrays.asList(");
        for (int i = 0; i < $subrule.textList.size(); i++) {
            $builder.append($subrule.textList.get(i).getName());
            if (i != $subrule.textList.size() - 1) {
                $builder.append(", ");
            }
        }
        $builder.append(")));\n");
        rules.add(new Rule(new NonTerminal($NNAME.text), $subrule.textList.stream().map(Wrapper<Element>::getElement).collect(Collectors.toList())));
    })* subrule {
        $builder.append("        rules.add(new Rule(" + $NNAME.text + ", Arrays.asList(");
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
        addElement("Terminal " + $TNAME.text + " = new Terminal(\"" + $TNAME.text +
         "\", \"" + $TEXT.text.substring(1, $TEXT.text.length() - 1) + "\", " +
          ($needToSkip ? "true" : "false") + ");");
        terminals.add($TNAME.text);
    };

subrule returns [List<Wrapper<Element>> textList]
@init {
    $textList = new ArrayList<Wrapper<Element>>();
}
:
    (TNAME {
        $textList.add(new Wrapper($TNAME.text, new Terminal($TNAME.text, "", false)));
        terminals.add($TNAME.text);
    }| NNAME {
        $textList.add(new Wrapper($NNAME.text, new NonTerminal($NNAME.text)));
    }| TEXT {
        String name = Terminal.getName("PRODUCED");
        addElement("Terminal " + name + " = new Terminal(\"" + name + "\", \"" + $TEXT.text.substring(1, $TEXT.text.length() - 1) + "\", false);");
        $textList.add(new Wrapper(name, new Terminal(name, "", false)));
        terminals.add(name);
    })+;

NNAME: [a-z][a-zA-Z0-9_]*;
TNAME: [A-Z][a-zA-Z0-9_]*;
TEXT: '\''.*?~('\\')'\'';
WS: [ \n\t]+ -> skip;