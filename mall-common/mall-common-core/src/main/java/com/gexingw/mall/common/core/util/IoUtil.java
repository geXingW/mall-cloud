package com.gexingw.mall.common.core.util;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * smart-logistics-saas.
 *
 * @author W.sf
 * @date 2023/8/9 17:07
 */
public class IoUtil {

    public static String toString(InputStream input, String encoding) throws IOException {
        if (input == null) {
            return "";
        }

        if (encoding == null) {
            return toString(new InputStreamReader(input, StandardCharsets.UTF_8));
        }

        return toString(new InputStreamReader(input, encoding));
    }

    public static String toString(Reader reader) throws IOException {
        CharArrayWriter sw = new CharArrayWriter();
        copy(reader, sw);
        return sw.toString();
    }

    public static void copy(Reader input, Writer output) throws IOException {
        char[] buffer = new char[1 << 12];
        for (int n; (n = input.read(buffer)) >= 0; ) {
            output.write(buffer, 0, n);
        }
    }
}
