import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nikita on 17.01.18.
 */
public class GenerateAttributes {
    private final Map<String, String> result;

    GenerateAttributes() {
        result = new HashMap<>();
    }

    public Map<String, String> getResult() {
        return result;
    }

    private static boolean canContinue(char a) {
        return ('a' <= a && a <= 'z') || ('A' <= a && a <= 'Z') || a == '.';
    }

    private static Pair<String, Integer> getCorrectPair(Pair<String, Integer> pair, Map<String, Map<String, Pair<String, Integer>>> params, String name) {
        int prev = 0;
        if (params.get(name) != null) {
            prev = params.get(name).size();
        }
        return new Pair<>(pair.first(), pair.second() - prev);
    }

    public void resolve(List<Pair<String, String>> args,
                               String parent,
                               Map<String, Map<String, Pair<String, Integer>>> params,
                               Map<String, Map<String, Pair<String, Integer>>> rets,
                               Map<String, Pair<String, Integer>> locals) {
        Map<String, Integer> map = new HashMap<>();
        if (!result.containsKey(parent)) {
            result.put(parent, "");
        }
        for (int j = 0; j < args.size(); j++) {
            Pair<String, String> pair = args.get(j);
            StringBuilder b = new StringBuilder();
            for (int i = 0; i < pair.second().length(); i++) {
                if (pair.second().charAt(i) == '$') {
                    i++;
                    StringBuilder builder = new StringBuilder();
                    String name = parent;
                    boolean wasPoint = false;
                    for (; i < pair.second().length() && canContinue(pair.second().charAt(i)); i++) {
                        if (!wasPoint && pair.second().charAt(i) == '.') {
                            wasPoint = true;
                            name = builder.toString();
                            builder = new StringBuilder();
                        } else {
                            builder.append(pair.second().charAt(i));
                        }
                    }
                    StringBuilder tmp = new StringBuilder();
                    tmp.append("((Wrapper<");
                    String need = builder.toString();
                    Pair<String, Integer> p;
                    boolean truth = false;
                    if (!wasPoint) {
                        if (locals == null || locals.get(need) == null) {
                            if (rets.get(parent) == null || rets.get(parent).get(need) == null) {
                                if (params.get(parent) == null || params.get(parent).get(need) == null) {
                                    throw new NullPointerException();
                                } else {
                                    p = params.get(parent).get(need);
                                    truth = true;
                                }
                            } else {
                                p = getCorrectPair(rets.get(parent).get(need), params, parent);
                            }
                        } else {
                            p = getCorrectPair(locals.get(need), params, parent);
                        }
                    } else {
                        if (need.equals("text")) {
                            p = new Pair<>("String", 0);
                        } else {
                            if (rets.get(name) == null || rets.get(name).get(need) == null) {
                                System.err.println(name + " " + need);
                                throw new NullPointerException();
                            } else {
                                p = getCorrectPair(rets.get(name).get(need), params, name);
                            }
                        }
                    }

                    tmp.append(p.first());
                    tmp.append(">)___elements.get(___elements.size() - ");
                    if (!wasPoint) {
                        if (truth) {
                            tmp.append(j + 1);
                        } else {
                            tmp.append(j);
                        }
                    } else {
                        tmp.append(j - map.get(name));
                    }
                    tmp.append(").get(");
                    tmp.append(p.second());
                    tmp.append(")).object");
                    b.append(tmp);
                }
                b.append(pair.second().charAt(i));
            }
            map.put(pair.first(), j);
            result.put(pair.first(), b.toString());
        }
    }
}
