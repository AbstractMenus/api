package ru.abstractmenus.api.variables;

public interface VarBuilder {

    /**
     * Get current key
     * @return Current key
     */
    String key();

    /**
     * Get current value
     * @return Current value
     */
    String value();

    /**
     * Get current expiry time
     * @return Current expiry time
     */
    long expiry();

    /**
     * Set expiry time to variable
     * @param key Variable key. Key should contain only latin chars and special symbol `_`
     * @return Builder instance
     */
    VarBuilder key(String key);

    /**
     * Set expiry time to variable
     * @param value Variable value
     * @return Builder instance
     */
    VarBuilder value(String value);

    /**
     * Set expiry time to variable
     * @param expiry Expiry time in millis. Use System.currentTimeMillis() to
     *               get current time and add required millis to variable lifetime
     * @return Builder instance
     */
    VarBuilder expiry(long expiry);

    /**
     * Build new variable
     * @return New variable
     */
    Var build();

}
