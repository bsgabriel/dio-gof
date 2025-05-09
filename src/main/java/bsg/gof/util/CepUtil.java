package bsg.gof.util;

import static java.util.Objects.isNull;

public final class CepUtil {

    private CepUtil() {
    }

    public static Long cepParaLong(String cep) {
        if (isNull(cep) || cep.isBlank()) {
            return null;
        }

        return Long.valueOf(cep.replaceAll("\\D", ""));
    }

    public static String formatarCep(Long cep) {
        if (isNull(cep)) {
            return null;
        }
        var cepStr = String.format("%08d", cep);
        return cepStr.substring(0, 5) + "-" + cepStr.substring(5);
    }

}
