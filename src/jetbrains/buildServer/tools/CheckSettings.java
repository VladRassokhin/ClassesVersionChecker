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

package jetbrains.buildServer.tools;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;

/**
 * @author Eugene Petrenko (eugene.petrenko@gmail.com)
 *         Date: 08.11.11 13:52
 */
public interface CheckSettings {

  boolean isDebugMode();

  boolean isPathExcluded(@NotNull final ScanFile file);

  /**
   * returns the way file must be checked
   * @param file fill file path with ! to split archive
   * @param error error reporter if needed
   * @return check action or null
   */
  @NotNull
  Collection<? extends CheckAction> getFileCheckMode(@NotNull final ScanFile file,
                                                     @NotNull final ErrorReporting error);
}
