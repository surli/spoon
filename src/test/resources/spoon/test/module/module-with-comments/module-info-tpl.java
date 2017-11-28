/**
 * This is the main module of the application
 */
open module anothermodule {
    requires static java.logging; // this is needed for logging stuff

    /**
     * A specific implementation
     */
    provides java.logging.Service with com.greetings.logging.Logger;

    /*
     * A simple implementation
     */
    uses java.logging.Logger;
}
