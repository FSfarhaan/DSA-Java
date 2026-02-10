.charAt(i) - '0';
            if (digit % 2 == 1) {
                return s.substring(0, i + 1);
            }
        }
        return "";