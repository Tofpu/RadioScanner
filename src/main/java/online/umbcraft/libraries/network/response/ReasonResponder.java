package online.umbcraft.libraries.network.response;

import online.umbcraft.libraries.encrypt.HelpfulRSAKeyPair;
import online.umbcraft.libraries.network.message.RadioMessage;
import online.umbcraft.libraries.network.message.ReasonMessage;
import online.umbcraft.libraries.network.message.ResponseMessage;

import java.security.PrivateKey;
import java.util.HashSet;
import java.util.Set;

/**
 * <p> Responsible for responding to a single type/reason of {@link RadioMessage} </p>
 * Extend this class to add custom logic for whenever a RadioMessage is received
 *
 * @see ReasonResponder
 * @see RadioMessage
 */

public abstract class ReasonResponder {

    private final String reason;
    private final HelpfulRSAKeyPair keypair;
    private final Set<String> known;

    /**
     * Creates a blank ReasonResponder and sets the reason
     *
     * @param reason <p> String which if any {@link RadioMessage} </p> share, this will reply to them
     * @param pair   the RSA keyset used to encode / decode messages
     */
    public ReasonResponder(String reason, HelpfulRSAKeyPair pair) {
        this.reason = reason;
        this.keypair = pair;
        known = new HashSet<>();
    }


    /**
     * adds an RSA public key to the list of recognized keys
     *
     * @param remote_public the public RSA key to be added to the list of known keys
     */
    public final void addKnown(String remote_public) {
        known.add(remote_public);
    }


    /**
     * removes an RSA public key from the list of recognized keys
     *
     * @param remote_public the public RSA key to be removed from the list of known keys
     */
    public final void removeKnown(String remote_public) {
        known.remove(remote_public);
    }


    /**
     * Returns whether or not this remote RSA public key is recognized
     *
     * @param remote_public_b64 the public RSA key of the incoming message's host
     * @return if the RSA key is known
     */
    public final boolean isKnown(String remote_public_b64) {
        return known.contains(remote_public_b64);
    }


    /**
     * Returns the {@link RadioMessage} reason this object responds to
     *
     * @return the type of message this responds to
     */
    public final String getReason() {
        return reason;
    }


    /**
     * Returns the {@link PrivateKey} this reason uses
     *
     * @return the type of message this responds to
     */
    public final HelpfulRSAKeyPair getKeypair() {
        return keypair;
    }


    /**
     * generates a {@link RadioMessage} to be sent in response to an incoming {@link RadioMessage}
     *
     * @param message the incoming message
     * @return the generated reply
     */
    public abstract ResponseMessage response(ReasonMessage message);
}
