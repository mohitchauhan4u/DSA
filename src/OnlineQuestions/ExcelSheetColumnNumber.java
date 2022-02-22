package OnlineQuestions;

public class ExcelSheetColumnNumber {
    public static int titleToNumber(String columnTitle) {
        var columnNumber = 0;
        for (var i = 0; i < columnTitle.length(); i++){
            columnNumber = columnNumber * 26 + columnTitle.charAt(i) - 'A' + 1;
        }
        return columnNumber;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
        System.out.println(titleToNumber("AB"));
        System.out.println(titleToNumber("A"));
    }
}
