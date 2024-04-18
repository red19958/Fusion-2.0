package types

data class KeyboardOptions(

    /**
     * Capitalization strategy that should be applied to the text
     */
    var capitalization: KeyboardCapitalization? = null,

    /**
     * The text being entered should have auto-correction applied to it
     */
    var autoCorrect: Boolean? = false,

    /**
     * Specifies set of displayed keys of the keyboard (e.g. standard, numbers only, ..)
     */
    var keyboardType: KeyboardType? = null,

    /**
     * Type of action to be invoked when user clicks bottom right key.
     * Also specifies the appearance of that key
     */
    var imeAction: ImeAction? = null,

    /**
     * Specifies the type of action to be invoked when the user interacts with the toolbar
     * located above the keyboard.
     */
    var inputAccessoryAction: ImeAction? = null,
)
