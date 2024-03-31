package build;

// The interface that only accpect one method
@FunctionalInterface
interface StringAnalyzer {
    public boolean analyze(String target, String searchStr);
}

class ContainsAnalyzer implements StringAnalyzer {
    public boolean analyze(String target, String searchStr) {
        return target.contains(searchStr);
    }
}

class StartWithAnalyzer implements StringAnalyzer {
    public boolean analyze(String target, String searchStr) {
        return target.startsWith(searchStr);
    }
}

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        String target = "Jim is teaching";
        String searchStr = "Jim";

        StringAnalyzer analyzer1 = new ContainsAnalyzer();
        System.out.println(analyzeString(analyzer1, target, searchStr));

        StringAnalyzer analyzer2 = new StartWithAnalyzer();
        System.out.println(analyzeString(analyzer2, target, searchStr));

        // Lambda expression
        StringAnalyzer analyzer3 = (t, s) -> t.equals(s);
        System.out.println(analyzeString(analyzer3, target, searchStr));
    }

    private static boolean analyzeString(StringAnalyzer analyzer, 
                                        String target, 
                                        String searchStr) {
        return analyzer.analyze(target, searchStr);
    }
}
