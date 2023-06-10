package org.openehr.term_terminology.terminology;

import java.lang.String;

/**
 * A single code entity in a code set.
 */
public interface Code {
  /**
   * The code string for this code entity.
   */
  String getValue();

  String getDescription();
}
