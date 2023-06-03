import java.util.*;

class LanguageMaster {
    private static final String MAIN_LANGUAGE = "English";
    private static final Map<String, Map<String, String>> languageData = new HashMap<>();

    static {
        // Swedish language data
        Map<String, String> swedishVocabulary = new HashMap<>();
        swedishVocabulary.put("Människa", "Human");
        swedishVocabulary.put("Hund", "Dog");
        swedishVocabulary.put("Bil", "Car");
        languageData.put("Swedish", swedishVocabulary);

        // German language data
        Map<String, String> germanVocabulary = new HashMap<>();
        germanVocabulary.put("Mensch", "Human");
        germanVocabulary.put("Hund", "Dog");
        germanVocabulary.put("Auto", "Car");
        languageData.put("German", germanVocabulary);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to LanguageMaster!");
        System.out.println("Available languages:");
        for (String language : languageData.keySet()) {
            System.out.println("- " + language);
        }

        System.out.print("Please select a language: ");
        String selectedLanguage = scanner.nextLine();

        if (!languageData.containsKey(selectedLanguage)) {
            System.out.println("Invalid language selection. Exiting...");
            return;
        }

        Map<String, String> vocabulary = languageData.get(selectedLanguage);

        System.out.println("\nLet's learn " + selectedLanguage + "!");
        int choice;
        do {
            printMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    lookupWord(vocabulary, scanner);
                    break;
                case 2:
                    addWord(vocabulary, scanner);
                    break;
                case 3:
                    removeWord(vocabulary, scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using LanguageMaster!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);
    }

    private static void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Lookup a word");
        System.out.println("2. Add a word");
        System.out.println("3. Remove a word");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void lookupWord(Map<String, String> vocabulary, Scanner scanner) {
        System.out.print("Enter a word: ");
        String word = scanner.nextLine();
        String translation = vocabulary.get(word);
        if (translation != null) {
            System.out.println("Translation: " + translation);
        } else {
            System.out.println("Word not found in the " + selectedLanguage + " vocabulary.");
        }
    }

    private static void addWord(Map<String, String> vocabulary, Scanner scanner) {
        System.out.print("Enter a new word in " + selectedLanguage + ": ");
        String newWord = scanner.nextLine();
        System.out.print("Enter its translation in " + MAIN_LANGUAGE + ": ");
        String translation = scanner.nextLine();
        vocabulary.put(newWord, translation);
        System.out.println("Word added successfully!");
    }

    private static void removeWord(Map<String, String> vocabulary, Scanner scanner) {
        System.out.print("Enter a word to remove: ");
        String word = scanner.nextLine();
        String translation = vocabulary.remove(word);
        if (translation != null) {
            System.out.println("Word removed successfully!");
        } else {
            System.out.println("Word not found in the " + selectedLanguage + " vocabulary.");
        }
    }
}
