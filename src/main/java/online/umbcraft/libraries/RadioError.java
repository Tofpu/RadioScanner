package online.umbcraft.libraries;



/**
 * All possible errors which can be returned by a failed{@link RadioMessage}<p>
 * the format that the{@link RadioMessage} will contain the error in is:<p>
 * "TRANSMIT_ERROR" = "{@link RadioError}"
 */
public enum RadioError {


    /**
     * receiver did not have a valid{@link ReasonResponder}
     * to be able to respond to this message
     */
    NO_VALID_REASON,


    /**
     *{@link RadioMessage} failed to connect to the specified IPv4 address
     */
    FAILED_TO_CONNECT,


    /**
     *{@link RadioMessage} encountered an issue with reading / writing to the socket
     */
    BAD_NETWORK_RESPONSE,


    /**
     *{@link RadioMessage} was not able to decrypt the reply with its RSA key
     */
    BAD_RSA_KEY,


    /**
     *{@link RadioMessage} the json format of the response was invalid
     */
    INVALID_JSON,


    /**
     *{@link RadioMessage} encountered a bad signature from the reply
     */
    INVALID_SIGNATURE;

}
