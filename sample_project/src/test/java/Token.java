import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;

public class Token {

    public static int getNumberOfLowerCaseChars(String string) {
        return (int) string.chars().filter(Character::isLowerCase).count();
    }

    public static String getAlphaNumericString(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    private static void generateVerificationToken(String lookup, String password) {
        String prefixSalt = getAlphaNumericString(5);
        String suffixSalt = getAlphaNumericString(getNumberOfLowerCaseChars(prefixSalt));
        System.out.println(prefixSalt + DigestUtils.md5Hex((lookup + suffixSalt)) + DigestUtils.md5Hex((password + suffixSalt)) + suffixSalt);
    }

    public static void main(String[] args) {

        generateVerificationToken("K1aSOcWV70nnU3AEcllOl6ghrN0Tv9lex9toe17%2FmfLmgJKSBALSrxQurLRidtSABVpfxgwBs3Eu9aZNl4n3hnav3Nn3LHjeOE3uLnGOkWtXagi%2BwILXCZUIl7eE249q3tYaIirykpFf1VfbLOQkHaLOfPnvsioks%2FA1XT8IKfNHcE8J7tZ7%2B%2Fe%2B9QKxVCOX", "12345");
    }
}
