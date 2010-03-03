/*
 * Copyright 2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */  

package org.spockframework.runtime

import spock.lang.*

class SpecUtilSpec extends Specification {
  def "a class that doesn't extend Specification is not a spec"() {
    expect:
    !SpecUtil.isSpec(NotExtendingSpecification)
    !SpecUtil.isRunnableSpec(NotExtendingSpecification)
  }

  def "class Specification is not a spec"() {
    expect:
    !SpecUtil.isSpec(Specification)
    !SpecUtil.isRunnableSpec(Specification)
  }

  def "an abstract class extending Specification is a spec but isn't runnable"() {
    expect:
    SpecUtil.isSpec(AbstractSpec)
    !SpecUtil.isRunnableSpec(AbstractSpec)
  }

  def "a concrete class directly extending Specification is a spec and is runnable"() {
    expect:
    SpecUtil.isSpec(ConcreteSpec)
    SpecUtil.isRunnableSpec(ConcreteSpec)
  }

  def "a concrete class indirectly extending Specification is a spec and is runnable"() {
    expect:
    SpecUtil.isSpec(DerivedSpec)
    SpecUtil.isRunnableSpec(DerivedSpec)
  }
}

private class NotExtendingSpecification extends ArrayList {}

private abstract class AbstractSpec extends Specification {}

private class ConcreteSpec extends Specification {}

private class DerivedSpec extends ConcreteSpec {}