/*
 * Copyright 2000-2013 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jetbrains.buildServer.tools;

import org.jetbrains.annotations.NotNull;

/**
 * Created 31.10.13 11:23
 *
 * @author Eugene Petrenko (eugene.petrenko@jetbrains.com)
 */
public class HEX {
  public static String hex(@NotNull final byte[] raw) {
    final StringBuilder hex = new StringBuilder(3 * raw.length);
    int acc = 0;
    int bits = 0;
    int i = 0;

    while(true) {
      if (bits < 6) {
        if (i < raw.length) {
          acc += (raw[i++] & 0xFF) << bits;
          bits += 8;
        }
      }
      if (bits <= 0) break;

      hex.append(base64Chars[(acc % 64)]);
      acc /= 64;
      bits -= 6;
    }
    return hex.toString();
  }

  /**
   * Table of the sixty-four characters that are used as
   * the Base64 alphabet: [a-z0-9A-Z+/]
   */
  protected static final char[] base64Chars = {
          'A','B','C','D','E','F','G','H',
          'I','J','K','L','M','N','O','P',
          'Q','R','S','T','U','V','W','X',
          'Y','Z','a','b','c','d','e','f',
          'g','h','i','j','k','l','m','n',
          'o','p','q','r','s','t','u','v',
          'w','x','y','z','0','1','2','3',
          '4','5','6','7','8','9','+','/',
  };
}
