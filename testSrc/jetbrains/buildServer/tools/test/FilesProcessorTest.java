/*
 * Copyright 2000-2011 JetBrains s.r.o.
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

package jetbrains.buildServer.tools.test;

import jetbrains.buildServer.tools.FilesProcessor;
import jetbrains.buildServer.tools.java.JavaCheckSettings;
import jetbrains.buildServer.tools.rules.PathSettings;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * @author Eugene Petrenko (eugene.petrenko@gmail.com)
 *         Date: 11.11.11 16:03
 */
public class FilesProcessorTest extends FilesProcessorTestCase {

  @Override
  protected void runTest(@NotNull final String config) throws IOException {
    final PathSettings rules = parseConfig(config);
    FilesProcessor.processFiles(myHome, new JavaCheckSettings(rules), rep);
    rules.assertVisited(rep);
  }

}
