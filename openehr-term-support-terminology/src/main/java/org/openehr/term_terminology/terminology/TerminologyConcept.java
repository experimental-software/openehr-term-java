package org.openehr.term_terminology.terminology;

import java.lang.String;

/**
 * A single terminology concept in a vocabulary.
 */
public interface TerminologyConcept {
  /**
   * The code of this concept.
   */
  String getId();

  /**
   * The rubric, i.e. linguistic expression, of this concept, in the language of this terminology instance.
   */
  String getRubric();
}
