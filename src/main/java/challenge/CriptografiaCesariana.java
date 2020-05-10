package challenge;

    public class CriptografiaCesariana implements Criptografia {

        @Override
        public String criptografar(String texto) {
            filtraInput(texto);
            return crypto(texto.toLowerCase(), true, 3);
        }

        @Override
        public String descriptografar(String texto) {
            filtraInput(texto);
            return crypto(texto.toLowerCase(), false, 3);
        }

        private void filtraInput(String input) {
            if (input == "") {
                throw new IllegalArgumentException();
            } else if (input == null) {
                throw new NullPointerException();
            }
        }

        // Na "criptografia de Júlio César" usa-se offset 3
        private String crypto(String code, boolean encrypt, int offset) {
            int codePoint = 0;
            char[] cryptoText = new char[code.length()];

            // codepoints:
            //   'a' == 97
            //   'z' == 122
            for (int i = 0; i < code.length(); i++) {
                codePoint = code.codePointAt(i);
                if (codePoint >= 97 && codePoint <= 122) {
                    if (encrypt) {
                        codePoint += offset;
                    } else {
                        codePoint -= offset;
                    }
                    if (codePoint < 97)
                        codePoint = 123 - (97 - codePoint);
                }
                cryptoText[i] = Character.toChars(codePoint)[0];
            }
            return new String(cryptoText);
        }
    }



