package org.openehr.term_terminology.terminology;

import java.lang.String;
import java.util.List;

/**
 * A single vocabulary, in a particular language, within a Terminology.
 */
public interface TerminologyGroup {
  /**
   * Name of this vocabulary.
   */
  String getName();

  List getConcepts();
}
