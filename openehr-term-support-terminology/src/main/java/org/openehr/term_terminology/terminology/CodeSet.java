package org.openehr.term_terminology.terminology;

import java.lang.String;
import java.util.List;

/**
 * A code set.
 */
public interface CodeSet {
  /**
   * Name of the issuing organisation.
   */
  String getIssuer();

  /**
   * Identifier used for code set in the openEHR Reference Model.
   */
  String getOpenehrId();

  /**
   * An identifier assumed by openEHR to be the identifier of this code set, based on its published name, with spaces replaced by underscores.
   */
  String getExternalId();

  /**
   * Codes in this code set.
   */
  List getCodes();
}
