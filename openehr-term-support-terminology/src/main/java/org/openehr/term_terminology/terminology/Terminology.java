package org.openehr.term_terminology.terminology;

import java.lang.String;
import java.util.List;

public interface Terminology {
  String getName();

  String getLanguage();

  /**
   * Code sets in this Terminology.
   */
  List getCodeSets();

  /**
   * Vocabularies of coded terms in this terminology.
   */
  List getVocabularies();
}
