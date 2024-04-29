package grammar

import org.antlr.v4.runtime.NoViableAltException
import org.antlr.v4.runtime.Parser
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.RuntimeMetaData
import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.TokenStream
import org.antlr.v4.runtime.Vocabulary
import org.antlr.v4.runtime.VocabularyImpl
import org.antlr.v4.runtime.atn.ATN
import org.antlr.v4.runtime.atn.ATNDeserializer
import org.antlr.v4.runtime.atn.ParserATNSimulator
import org.antlr.v4.runtime.atn.PredictionContextCache
import org.antlr.v4.runtime.dfa.DFA
import org.antlr.v4.runtime.tree.ParseTreeListener
import org.antlr.v4.runtime.tree.ParseTreeVisitor
import org.antlr.v4.runtime.tree.TerminalNode

@Suppress("unused")
class DSLGrammarParser(input: TokenStream?) : Parser(input) {
    @Deprecated("")
    override fun getTokenNames(): Array<String> {
        return tokenNames
    }

    override fun getVocabulary(): Vocabulary {
        return VOCABULARY
    }

    override fun getGrammarFileName(): String {
        return "DSLGrammar.g4"
    }

    override fun getRuleNames(): Array<String> {
        return Companion.ruleNames
    }

    override fun getSerializedATN(): String {
        return _serializedATN
    }

    override fun getATN(): ATN {
        return _ATN
    }

    class StartContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun layoutNode(): LayoutNodeContext {
            return getRuleContext(LayoutNodeContext::class.java, 0)
        }

        fun node(): NodeContext {
            return getRuleContext(NodeContext::class.java, 0)
        }

        fun fields(): List<FieldsContext> {
            return getRuleContexts(FieldsContext::class.java)
        }

        fun fields(i: Int): FieldsContext {
            return getRuleContext(FieldsContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_start
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterStart(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitStart(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitStart(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun start(): StartContext {
        val _localctx = StartContext(_ctx, state)
        enterRule(_localctx, 0, RULE_start)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 241
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la == VAL) {
                    run {
                        run {
                            state = 238
                            fields()
                        }
                    }
                    state = 243
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 246
                _errHandler.sync(this)
                when (_input.LA(1)) {
                    BOX, COLUMN, FLOW_ROW, LAZY_COLUMN, LAZY_ROW, ROW -> {
                        state = 244
                        layoutNode()
                    }

                    TEXT_NODE, TEXT_FIELD_NODE, IMAGE_NODE -> {
                        state = 245
                        node()
                    }

                    else -> throw NoViableAltException(this)
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class FieldsContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun VAL(): TerminalNode {
            return getToken(VAL, 0)
        }

        fun FIELD_NAME(): TerminalNode {
            return getToken(FIELD_NAME, 0)
        }

        fun ASSIGN(): TerminalNode {
            return getToken(ASSIGN, 0)
        }

        fun typeValue(): TypeValueContext {
            return getRuleContext(TypeValueContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_fields
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterFields(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitFields(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitFields(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun fields(): FieldsContext {
        val _localctx = FieldsContext(_ctx, state)
        enterRule(_localctx, 2, RULE_fields)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 248
                match(VAL)
                state = 249
                match(FIELD_NAME)
                state = 250
                match(ASSIGN)
                state = 251
                typeValue()
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class TypeValueContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun ARRAY(): TerminalNode {
            return getToken(ARRAY, 0)
        }

        fun DICTIONARY(): TerminalNode {
            return getToken(DICTIONARY, 0)
        }

        fun FBOOLEAN(): TerminalNode {
            return getToken(FBOOLEAN, 0)
        }

        fun FLONG(): TerminalNode {
            return getToken(FLONG, 0)
        }

        fun FDOUBLE(): TerminalNode {
            return getToken(FDOUBLE, 0)
        }

        fun FSTRING(): TerminalNode {
            return getToken(FSTRING, 0)
        }

        fun fStringArray(): FStringArrayContext {
            return getRuleContext(FStringArrayContext::class.java, 0)
        }

        fun fBooleanArray(): FBooleanArrayContext {
            return getRuleContext(FBooleanArrayContext::class.java, 0)
        }

        fun fDoubleArray(): FDoubleArrayContext {
            return getRuleContext(FDoubleArrayContext::class.java, 0)
        }

        fun fLongArray(): FLongArrayContext {
            return getRuleContext(FLongArrayContext::class.java, 0)
        }

        fun fStringDictionary(): FStringDictionaryContext {
            return getRuleContext(FStringDictionaryContext::class.java, 0)
        }

        fun fDoubleDictionary(): FDoubleDictionaryContext {
            return getRuleContext(FDoubleDictionaryContext::class.java, 0)
        }

        fun fLongDictionary(): FLongDictionaryContext {
            return getRuleContext(FLongDictionaryContext::class.java, 0)
        }

        fun fBooleanDictionary(): FBooleanDictionaryContext {
            return getRuleContext(FBooleanDictionaryContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_typeValue
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterTypeValue(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitTypeValue(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitTypeValue(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun typeValue(): TypeValueContext {
        val _localctx = TypeValueContext(_ctx, state)
        enterRule(_localctx, 4, RULE_typeValue)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 271
                _errHandler.sync(this)
                when (_input.LA(1)) {
                    ARRAY -> {
                        state = 253
                        match(ARRAY)
                        state = 258
                        _errHandler.sync(this)
                        when (interpreter.adaptivePredict(_input, 2, _ctx)) {
                            1 -> {
                                state = 254
                                fStringArray()
                            }

                            2 -> {
                                state = 255
                                fBooleanArray()
                            }

                            3 -> {
                                state = 256
                                fDoubleArray()
                            }

                            4 -> {
                                state = 257
                                fLongArray()
                            }

                            else -> {}
                        }
                    }

                    DICTIONARY -> {
                        state = 260
                        match(DICTIONARY)
                        state = 265
                        _errHandler.sync(this)
                        when (interpreter.adaptivePredict(_input, 3, _ctx)) {
                            1 -> {
                                state = 261
                                fStringDictionary()
                            }

                            2 -> {
                                state = 262
                                fDoubleDictionary()
                            }

                            3 -> {
                                state = 263
                                fLongDictionary()
                            }

                            4 -> {
                                state = 264
                                fBooleanDictionary()
                            }

                            else -> {}
                        }
                    }

                    FBOOLEAN -> {
                        state = 267
                        match(FBOOLEAN)
                    }

                    FLONG -> {
                        state = 268
                        match(FLONG)
                    }

                    FDOUBLE -> {
                        state = 269
                        match(FDOUBLE)
                    }

                    FSTRING -> {
                        state = 270
                        match(FSTRING)
                    }

                    else -> throw NoViableAltException(this)
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class FStringArrayContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun LEFT_BRACE(): TerminalNode {
            return getToken(LEFT_BRACE, 0)
        }

        fun fstringArrValue(): FstringArrValueContext {
            return getRuleContext(FstringArrValueContext::class.java, 0)
        }

        fun RIGHT_BRACE(): TerminalNode {
            return getToken(RIGHT_BRACE, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_fStringArray
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterFStringArray(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitFStringArray(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitFStringArray(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun fStringArray(): FStringArrayContext {
        val _localctx = FStringArrayContext(_ctx, state)
        enterRule(_localctx, 6, RULE_fStringArray)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 273
                match(LEFT_BRACE)
                state = 274
                fstringArrValue()
                state = 275
                match(RIGHT_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class FBooleanArrayContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun LEFT_BRACE(): TerminalNode {
            return getToken(LEFT_BRACE, 0)
        }

        fun fbooleanArrValue(): FbooleanArrValueContext {
            return getRuleContext(FbooleanArrValueContext::class.java, 0)
        }

        fun RIGHT_BRACE(): TerminalNode {
            return getToken(RIGHT_BRACE, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_fBooleanArray
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterFBooleanArray(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitFBooleanArray(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitFBooleanArray(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun fBooleanArray(): FBooleanArrayContext {
        val _localctx = FBooleanArrayContext(_ctx, state)
        enterRule(_localctx, 8, RULE_fBooleanArray)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 277
                match(LEFT_BRACE)
                state = 278
                fbooleanArrValue()
                state = 279
                match(RIGHT_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class FDoubleArrayContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun LEFT_BRACE(): TerminalNode {
            return getToken(LEFT_BRACE, 0)
        }

        fun fdoubleArrValue(): FdoubleArrValueContext {
            return getRuleContext(FdoubleArrValueContext::class.java, 0)
        }

        fun RIGHT_BRACE(): TerminalNode {
            return getToken(RIGHT_BRACE, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_fDoubleArray
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterFDoubleArray(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitFDoubleArray(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitFDoubleArray(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun fDoubleArray(): FDoubleArrayContext {
        val _localctx = FDoubleArrayContext(_ctx, state)
        enterRule(_localctx, 10, RULE_fDoubleArray)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 281
                match(LEFT_BRACE)
                state = 282
                fdoubleArrValue()
                state = 283
                match(RIGHT_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class FLongArrayContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun LEFT_BRACE(): TerminalNode {
            return getToken(LEFT_BRACE, 0)
        }

        fun flongArrValue(): FlongArrValueContext {
            return getRuleContext(FlongArrValueContext::class.java, 0)
        }

        fun RIGHT_BRACE(): TerminalNode {
            return getToken(RIGHT_BRACE, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_fLongArray
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterFLongArray(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitFLongArray(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitFLongArray(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun fLongArray(): FLongArrayContext {
        val _localctx = FLongArrayContext(_ctx, state)
        enterRule(_localctx, 12, RULE_fLongArray)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 285
                match(LEFT_BRACE)
                state = 286
                flongArrValue()
                state = 287
                match(RIGHT_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class FstringArrValueContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun FSTRING(): List<TerminalNode> {
            return getTokens(FSTRING)
        }

        fun FSTRING(i: Int): TerminalNode {
            return getToken(FSTRING, i)
        }

        fun COMMA(): List<TerminalNode> {
            return getTokens(COMMA)
        }

        fun COMMA(i: Int): TerminalNode {
            return getToken(COMMA, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_fstringArrValue
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterFstringArrValue(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitFstringArrValue(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitFstringArrValue(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun fstringArrValue(): FstringArrValueContext {
        val _localctx = FstringArrValueContext(_ctx, state)
        enterRule(_localctx, 14, RULE_fstringArrValue)
        var _la: Int
        try {
            var _alt: Int
            enterOuterAlt(_localctx, 1)
            run {
                state = 297
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == FSTRING) {
                    run {
                        state = 293
                        _errHandler.sync(this)
                        _alt = interpreter.adaptivePredict(_input, 5, _ctx)
                        while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
                            if (_alt == 1) {
                                run {
                                    run {
                                        state = 289
                                        match(FSTRING)
                                        state = 290
                                        match(COMMA)
                                    }
                                }
                            }
                            state = 295
                            _errHandler.sync(this)
                            _alt = interpreter.adaptivePredict(_input, 5, _ctx)
                        }
                        state = 296
                        match(FSTRING)
                    }
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class FbooleanArrValueContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun FBOOLEAN(): List<TerminalNode> {
            return getTokens(FBOOLEAN)
        }

        fun FBOOLEAN(i: Int): TerminalNode {
            return getToken(FBOOLEAN, i)
        }

        fun COMMA(): List<TerminalNode> {
            return getTokens(COMMA)
        }

        fun COMMA(i: Int): TerminalNode {
            return getToken(COMMA, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_fbooleanArrValue
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterFbooleanArrValue(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitFbooleanArrValue(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitFbooleanArrValue(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun fbooleanArrValue(): FbooleanArrValueContext {
        val _localctx = FbooleanArrValueContext(_ctx, state)
        enterRule(_localctx, 16, RULE_fbooleanArrValue)
        var _la: Int
        try {
            var _alt: Int
            enterOuterAlt(_localctx, 1)
            run {
                state = 307
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == FBOOLEAN) {
                    run {
                        state = 303
                        _errHandler.sync(this)
                        _alt = interpreter.adaptivePredict(_input, 7, _ctx)
                        while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
                            if (_alt == 1) {
                                run {
                                    run {
                                        state = 299
                                        match(FBOOLEAN)
                                        state = 300
                                        match(COMMA)
                                    }
                                }
                            }
                            state = 305
                            _errHandler.sync(this)
                            _alt = interpreter.adaptivePredict(_input, 7, _ctx)
                        }
                        state = 306
                        match(FBOOLEAN)
                    }
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class FdoubleArrValueContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun FDOUBLE(): List<TerminalNode> {
            return getTokens(FDOUBLE)
        }

        fun FDOUBLE(i: Int): TerminalNode {
            return getToken(FDOUBLE, i)
        }

        fun COMMA(): List<TerminalNode> {
            return getTokens(COMMA)
        }

        fun COMMA(i: Int): TerminalNode {
            return getToken(COMMA, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_fdoubleArrValue
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterFdoubleArrValue(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitFdoubleArrValue(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitFdoubleArrValue(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun fdoubleArrValue(): FdoubleArrValueContext {
        val _localctx = FdoubleArrValueContext(_ctx, state)
        enterRule(_localctx, 18, RULE_fdoubleArrValue)
        var _la: Int
        try {
            var _alt: Int
            enterOuterAlt(_localctx, 1)
            run {
                state = 317
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == FDOUBLE) {
                    run {
                        state = 313
                        _errHandler.sync(this)
                        _alt = interpreter.adaptivePredict(_input, 9, _ctx)
                        while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
                            if (_alt == 1) {
                                run {
                                    run {
                                        state = 309
                                        match(FDOUBLE)
                                        state = 310
                                        match(COMMA)
                                    }
                                }
                            }
                            state = 315
                            _errHandler.sync(this)
                            _alt = interpreter.adaptivePredict(_input, 9, _ctx)
                        }
                        state = 316
                        match(FDOUBLE)
                    }
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class FlongArrValueContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun FLONG(): List<TerminalNode> {
            return getTokens(FLONG)
        }

        fun FLONG(i: Int): TerminalNode {
            return getToken(FLONG, i)
        }

        fun COMMA(): List<TerminalNode> {
            return getTokens(COMMA)
        }

        fun COMMA(i: Int): TerminalNode {
            return getToken(COMMA, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_flongArrValue
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterFlongArrValue(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitFlongArrValue(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitFlongArrValue(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun flongArrValue(): FlongArrValueContext {
        val _localctx = FlongArrValueContext(_ctx, state)
        enterRule(_localctx, 20, RULE_flongArrValue)
        var _la: Int
        try {
            var _alt: Int
            enterOuterAlt(_localctx, 1)
            run {
                state = 327
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == FLONG) {
                    run {
                        state = 323
                        _errHandler.sync(this)
                        _alt = interpreter.adaptivePredict(_input, 11, _ctx)
                        while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
                            if (_alt == 1) {
                                run {
                                    run {
                                        state = 319
                                        match(FLONG)
                                        state = 320
                                        match(COMMA)
                                    }
                                }
                            }
                            state = 325
                            _errHandler.sync(this)
                            _alt = interpreter.adaptivePredict(_input, 11, _ctx)
                        }
                        state = 326
                        match(FLONG)
                    }
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class FStringDictionaryContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun LEFT_BRACE(): TerminalNode {
            return getToken(LEFT_BRACE, 0)
        }

        fun fstringDictValue(): FstringDictValueContext {
            return getRuleContext(FstringDictValueContext::class.java, 0)
        }

        fun RIGHT_BRACE(): TerminalNode {
            return getToken(RIGHT_BRACE, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_fStringDictionary
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterFStringDictionary(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitFStringDictionary(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitFStringDictionary(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun fStringDictionary(): FStringDictionaryContext {
        val _localctx = FStringDictionaryContext(_ctx, state)
        enterRule(_localctx, 22, RULE_fStringDictionary)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 329
                match(LEFT_BRACE)
                state = 330
                fstringDictValue()
                state = 331
                match(RIGHT_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class FDoubleDictionaryContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun LEFT_BRACE(): TerminalNode {
            return getToken(LEFT_BRACE, 0)
        }

        fun fdoubleDictValue(): FdoubleDictValueContext {
            return getRuleContext(FdoubleDictValueContext::class.java, 0)
        }

        fun RIGHT_BRACE(): TerminalNode {
            return getToken(RIGHT_BRACE, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_fDoubleDictionary
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterFDoubleDictionary(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitFDoubleDictionary(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitFDoubleDictionary(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun fDoubleDictionary(): FDoubleDictionaryContext {
        val _localctx = FDoubleDictionaryContext(_ctx, state)
        enterRule(_localctx, 24, RULE_fDoubleDictionary)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 333
                match(LEFT_BRACE)
                state = 334
                fdoubleDictValue()
                state = 335
                match(RIGHT_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class FLongDictionaryContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun LEFT_BRACE(): TerminalNode {
            return getToken(LEFT_BRACE, 0)
        }

        fun flongDictValue(): FlongDictValueContext {
            return getRuleContext(FlongDictValueContext::class.java, 0)
        }

        fun RIGHT_BRACE(): TerminalNode {
            return getToken(RIGHT_BRACE, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_fLongDictionary
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterFLongDictionary(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitFLongDictionary(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitFLongDictionary(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun fLongDictionary(): FLongDictionaryContext {
        val _localctx = FLongDictionaryContext(_ctx, state)
        enterRule(_localctx, 26, RULE_fLongDictionary)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 337
                match(LEFT_BRACE)
                state = 338
                flongDictValue()
                state = 339
                match(RIGHT_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class FBooleanDictionaryContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun LEFT_BRACE(): TerminalNode {
            return getToken(LEFT_BRACE, 0)
        }

        fun fbooleanDictValue(): FbooleanDictValueContext {
            return getRuleContext(FbooleanDictValueContext::class.java, 0)
        }

        fun RIGHT_BRACE(): TerminalNode {
            return getToken(RIGHT_BRACE, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_fBooleanDictionary
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterFBooleanDictionary(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitFBooleanDictionary(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitFBooleanDictionary(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun fBooleanDictionary(): FBooleanDictionaryContext {
        val _localctx = FBooleanDictionaryContext(_ctx, state)
        enterRule(_localctx, 28, RULE_fBooleanDictionary)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 341
                match(LEFT_BRACE)
                state = 342
                fbooleanDictValue()
                state = 343
                match(RIGHT_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class FstringDictValueContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun FSTRING(): List<TerminalNode> {
            return getTokens(FSTRING)
        }

        fun FSTRING(i: Int): TerminalNode {
            return getToken(FSTRING, i)
        }

        fun TO(): List<TerminalNode> {
            return getTokens(TO)
        }

        fun TO(i: Int): TerminalNode {
            return getToken(TO, i)
        }

        fun COMMA(): List<TerminalNode> {
            return getTokens(COMMA)
        }

        fun COMMA(i: Int): TerminalNode {
            return getToken(COMMA, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_fstringDictValue
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterFstringDictValue(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitFstringDictValue(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitFstringDictValue(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun fstringDictValue(): FstringDictValueContext {
        val _localctx = FstringDictValueContext(_ctx, state)
        enterRule(_localctx, 30, RULE_fstringDictValue)
        var _la: Int
        try {
            var _alt: Int
            enterOuterAlt(_localctx, 1)
            run {
                state = 357
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == FSTRING) {
                    run {
                        state = 351
                        _errHandler.sync(this)
                        _alt = interpreter.adaptivePredict(_input, 13, _ctx)
                        while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
                            if (_alt == 1) {
                                run {
                                    run {
                                        state = 345
                                        match(FSTRING)
                                        state = 346
                                        match(TO)
                                        state = 347
                                        match(FSTRING)
                                        state = 348
                                        match(COMMA)
                                    }
                                }
                            }
                            state = 353
                            _errHandler.sync(this)
                            _alt = interpreter.adaptivePredict(_input, 13, _ctx)
                        }
                        state = 354
                        match(FSTRING)
                        state = 355
                        match(TO)
                        state = 356
                        match(FSTRING)
                    }
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class FdoubleDictValueContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun FSTRING(): List<TerminalNode> {
            return getTokens(FSTRING)
        }

        fun FSTRING(i: Int): TerminalNode {
            return getToken(FSTRING, i)
        }

        fun TO(): List<TerminalNode> {
            return getTokens(TO)
        }

        fun TO(i: Int): TerminalNode {
            return getToken(TO, i)
        }

        fun FDOUBLE(): List<TerminalNode> {
            return getTokens(FDOUBLE)
        }

        fun FDOUBLE(i: Int): TerminalNode {
            return getToken(FDOUBLE, i)
        }

        fun COMMA(): List<TerminalNode> {
            return getTokens(COMMA)
        }

        fun COMMA(i: Int): TerminalNode {
            return getToken(COMMA, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_fdoubleDictValue
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterFdoubleDictValue(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitFdoubleDictValue(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitFdoubleDictValue(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun fdoubleDictValue(): FdoubleDictValueContext {
        val _localctx = FdoubleDictValueContext(_ctx, state)
        enterRule(_localctx, 32, RULE_fdoubleDictValue)
        var _la: Int
        try {
            var _alt: Int
            enterOuterAlt(_localctx, 1)
            run {
                state = 371
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == FSTRING) {
                    run {
                        state = 365
                        _errHandler.sync(this)
                        _alt = interpreter.adaptivePredict(_input, 15, _ctx)
                        while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
                            if (_alt == 1) {
                                run {
                                    run {
                                        state = 359
                                        match(FSTRING)
                                        state = 360
                                        match(TO)
                                        state = 361
                                        match(FDOUBLE)
                                        state = 362
                                        match(COMMA)
                                    }
                                }
                            }
                            state = 367
                            _errHandler.sync(this)
                            _alt = interpreter.adaptivePredict(_input, 15, _ctx)
                        }
                        state = 368
                        match(FSTRING)
                        state = 369
                        match(TO)
                        state = 370
                        match(FDOUBLE)
                    }
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class FlongDictValueContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun FSTRING(): List<TerminalNode> {
            return getTokens(FSTRING)
        }

        fun FSTRING(i: Int): TerminalNode {
            return getToken(FSTRING, i)
        }

        fun TO(): List<TerminalNode> {
            return getTokens(TO)
        }

        fun TO(i: Int): TerminalNode {
            return getToken(TO, i)
        }

        fun FLONG(): List<TerminalNode> {
            return getTokens(FLONG)
        }

        fun FLONG(i: Int): TerminalNode {
            return getToken(FLONG, i)
        }

        fun COMMA(): List<TerminalNode> {
            return getTokens(COMMA)
        }

        fun COMMA(i: Int): TerminalNode {
            return getToken(COMMA, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_flongDictValue
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterFlongDictValue(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitFlongDictValue(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitFlongDictValue(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun flongDictValue(): FlongDictValueContext {
        val _localctx = FlongDictValueContext(_ctx, state)
        enterRule(_localctx, 34, RULE_flongDictValue)
        var _la: Int
        try {
            var _alt: Int
            enterOuterAlt(_localctx, 1)
            run {
                state = 385
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == FSTRING) {
                    run {
                        state = 379
                        _errHandler.sync(this)
                        _alt = interpreter.adaptivePredict(_input, 17, _ctx)
                        while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
                            if (_alt == 1) {
                                run {
                                    run {
                                        state = 373
                                        match(FSTRING)
                                        state = 374
                                        match(TO)
                                        state = 375
                                        match(FLONG)
                                        state = 376
                                        match(COMMA)
                                    }
                                }
                            }
                            state = 381
                            _errHandler.sync(this)
                            _alt = interpreter.adaptivePredict(_input, 17, _ctx)
                        }
                        state = 382
                        match(FSTRING)
                        state = 383
                        match(TO)
                        state = 384
                        match(FLONG)
                    }
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class FbooleanDictValueContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun FSTRING(): List<TerminalNode> {
            return getTokens(FSTRING)
        }

        fun FSTRING(i: Int): TerminalNode {
            return getToken(FSTRING, i)
        }

        fun TO(): List<TerminalNode> {
            return getTokens(TO)
        }

        fun TO(i: Int): TerminalNode {
            return getToken(TO, i)
        }

        fun FBOOLEAN(): List<TerminalNode> {
            return getTokens(FBOOLEAN)
        }

        fun FBOOLEAN(i: Int): TerminalNode {
            return getToken(FBOOLEAN, i)
        }

        fun COMMA(): List<TerminalNode> {
            return getTokens(COMMA)
        }

        fun COMMA(i: Int): TerminalNode {
            return getToken(COMMA, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_fbooleanDictValue
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterFbooleanDictValue(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitFbooleanDictValue(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitFbooleanDictValue(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun fbooleanDictValue(): FbooleanDictValueContext {
        val _localctx = FbooleanDictValueContext(_ctx, state)
        enterRule(_localctx, 36, RULE_fbooleanDictValue)
        var _la: Int
        try {
            var _alt: Int
            enterOuterAlt(_localctx, 1)
            run {
                state = 399
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == FSTRING) {
                    run {
                        state = 393
                        _errHandler.sync(this)
                        _alt = interpreter.adaptivePredict(_input, 19, _ctx)
                        while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
                            if (_alt == 1) {
                                run {
                                    run {
                                        state = 387
                                        match(FSTRING)
                                        state = 388
                                        match(TO)
                                        state = 389
                                        match(FBOOLEAN)
                                        state = 390
                                        match(COMMA)
                                    }
                                }
                            }
                            state = 395
                            _errHandler.sync(this)
                            _alt = interpreter.adaptivePredict(_input, 19, _ctx)
                        }
                        state = 396
                        match(FSTRING)
                        state = 397
                        match(TO)
                        state = 398
                        match(FBOOLEAN)
                    }
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class LayoutNodeContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun box(): BoxContext {
            return getRuleContext(BoxContext::class.java, 0)
        }

        fun column(): ColumnContext {
            return getRuleContext(ColumnContext::class.java, 0)
        }

        fun row(): RowContext {
            return getRuleContext(RowContext::class.java, 0)
        }

        fun flowRow(): FlowRowContext {
            return getRuleContext(FlowRowContext::class.java, 0)
        }

        fun lazyColumn(): LazyColumnContext {
            return getRuleContext(LazyColumnContext::class.java, 0)
        }

        fun lazyRow(): LazyRowContext {
            return getRuleContext(LazyRowContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_layoutNode
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterLayoutNode(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitLayoutNode(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitLayoutNode(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun layoutNode(): LayoutNodeContext {
        val _localctx = LayoutNodeContext(_ctx, state)
        enterRule(_localctx, 38, RULE_layoutNode)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 407
                _errHandler.sync(this)
                when (_input.LA(1)) {
                    BOX -> {
                        state = 401
                        box()
                    }

                    COLUMN -> {
                        state = 402
                        column()
                    }

                    ROW -> {
                        state = 403
                        row()
                    }

                    FLOW_ROW -> {
                        state = 404
                        flowRow()
                    }

                    LAZY_COLUMN -> {
                        state = 405
                        lazyColumn()
                    }

                    LAZY_ROW -> {
                        state = 406
                        lazyRow()
                    }

                    else -> throw NoViableAltException(this)
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class NodeContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun textNode(): TextNodeContext {
            return getRuleContext(TextNodeContext::class.java, 0)
        }

        fun imageNode(): ImageNodeContext {
            return getRuleContext(ImageNodeContext::class.java, 0)
        }

        fun textFieldNode(): TextFieldNodeContext {
            return getRuleContext(TextFieldNodeContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_node
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterNode(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitNode(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitNode(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun node(): NodeContext {
        val _localctx = NodeContext(_ctx, state)
        enterRule(_localctx, 40, RULE_node)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 412
                _errHandler.sync(this)
                when (_input.LA(1)) {
                    TEXT_NODE -> {
                        state = 409
                        textNode()
                    }

                    IMAGE_NODE -> {
                        state = 410
                        imageNode()
                    }

                    TEXT_FIELD_NODE -> {
                        state = 411
                        textFieldNode()
                    }

                    else -> throw NoViableAltException(this)
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class BoxContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun BOX(): TerminalNode {
            return getToken(BOX, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun layoutAttr(): List<LayoutAttrContext> {
            return getRuleContexts(LayoutAttrContext::class.java)
        }

        fun layoutAttr(i: Int): LayoutAttrContext {
            return getRuleContext(LayoutAttrContext::class.java, i)
        }

        fun viewAttr(): List<ViewAttrContext> {
            return getRuleContexts(ViewAttrContext::class.java)
        }

        fun viewAttr(i: Int): ViewAttrContext {
            return getRuleContext(ViewAttrContext::class.java, i)
        }

        fun tapAttr(): List<TapAttrContext> {
            return getRuleContexts(TapAttrContext::class.java)
        }

        fun tapAttr(i: Int): TapAttrContext {
            return getRuleContext(TapAttrContext::class.java, i)
        }

        fun layoutNode(): List<LayoutNodeContext> {
            return getRuleContexts(LayoutNodeContext::class.java)
        }

        fun layoutNode(i: Int): LayoutNodeContext {
            return getRuleContext(LayoutNodeContext::class.java, i)
        }

        fun node(): List<NodeContext> {
            return getRuleContexts(NodeContext::class.java)
        }

        fun node(i: Int): NodeContext {
            return getRuleContext(NodeContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_box
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterBox(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitBox(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitBox(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun box(): BoxContext {
        val _localctx = BoxContext(_ctx, state)
        enterRule(_localctx, 42, RULE_box)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 414
                match(BOX)
                state = 415
                match(LEFT_FIGURE_BRACE)
                state = 423
                _errHandler.sync(this)
                _la = _input.LA(1)
                while ((((_la) and 0x3f.inv()) == 0 && ((1L shl _la) and 536609790L) != 0L) || ((((_la - 75)) and 0x3f.inv()) == 0 && ((1L shl (_la - 75)) and 7L) != 0L)) {
                    run {
                        state = 421
                        _errHandler.sync(this)
                        when (_input.LA(1)) {
                            WIDTH, HEIGHT, WEIGHT, GRAVITY, MARGIN -> {
                                state = 416
                                layoutAttr()
                            }

                            TEST_TAG, ALPHA, PADDING, BACKGROUND, IS_ENABLED, IS_VISIBLE -> {
                                state = 417
                                viewAttr()
                            }

                            ON_TAP, ON_LONG_TAP, ON_PRESSED_CHANGE -> {
                                state = 418
                                tapAttr()
                            }

                            BOX, COLUMN, FLOW_ROW, LAZY_COLUMN, LAZY_ROW, ROW -> {
                                state = 419
                                layoutNode()
                            }

                            TEXT_NODE, TEXT_FIELD_NODE, IMAGE_NODE -> {
                                state = 420
                                node()
                            }

                            else -> throw NoViableAltException(this)
                        }
                    }
                    state = 425
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 426
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class ColumnContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun COLUMN(): TerminalNode {
            return getToken(COLUMN, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun layoutAttr(): List<LayoutAttrContext> {
            return getRuleContexts(LayoutAttrContext::class.java)
        }

        fun layoutAttr(i: Int): LayoutAttrContext {
            return getRuleContext(LayoutAttrContext::class.java, i)
        }

        fun viewAttr(): List<ViewAttrContext> {
            return getRuleContexts(ViewAttrContext::class.java)
        }

        fun viewAttr(i: Int): ViewAttrContext {
            return getRuleContext(ViewAttrContext::class.java, i)
        }

        fun tapAttr(): List<TapAttrContext> {
            return getRuleContexts(TapAttrContext::class.java)
        }

        fun tapAttr(i: Int): TapAttrContext {
            return getRuleContext(TapAttrContext::class.java, i)
        }

        fun layoutNode(): List<LayoutNodeContext> {
            return getRuleContexts(LayoutNodeContext::class.java)
        }

        fun layoutNode(i: Int): LayoutNodeContext {
            return getRuleContext(LayoutNodeContext::class.java, i)
        }

        fun node(): List<NodeContext> {
            return getRuleContexts(NodeContext::class.java)
        }

        fun node(i: Int): NodeContext {
            return getRuleContext(NodeContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_column
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterColumn(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitColumn(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitColumn(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun column(): ColumnContext {
        val _localctx = ColumnContext(_ctx, state)
        enterRule(_localctx, 44, RULE_column)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 428
                match(COLUMN)
                state = 429
                match(LEFT_FIGURE_BRACE)
                state = 437
                _errHandler.sync(this)
                _la = _input.LA(1)
                while ((((_la) and 0x3f.inv()) == 0 && ((1L shl _la) and 536609790L) != 0L) || ((((_la - 75)) and 0x3f.inv()) == 0 && ((1L shl (_la - 75)) and 7L) != 0L)) {
                    run {
                        state = 435
                        _errHandler.sync(this)
                        when (_input.LA(1)) {
                            WIDTH, HEIGHT, WEIGHT, GRAVITY, MARGIN -> {
                                state = 430
                                layoutAttr()
                            }

                            TEST_TAG, ALPHA, PADDING, BACKGROUND, IS_ENABLED, IS_VISIBLE -> {
                                state = 431
                                viewAttr()
                            }

                            ON_TAP, ON_LONG_TAP, ON_PRESSED_CHANGE -> {
                                state = 432
                                tapAttr()
                            }

                            BOX, COLUMN, FLOW_ROW, LAZY_COLUMN, LAZY_ROW, ROW -> {
                                state = 433
                                layoutNode()
                            }

                            TEXT_NODE, TEXT_FIELD_NODE, IMAGE_NODE -> {
                                state = 434
                                node()
                            }

                            else -> throw NoViableAltException(this)
                        }
                    }
                    state = 439
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 440
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class RowContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun ROW(): TerminalNode {
            return getToken(ROW, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun layoutAttr(): List<LayoutAttrContext> {
            return getRuleContexts(LayoutAttrContext::class.java)
        }

        fun layoutAttr(i: Int): LayoutAttrContext {
            return getRuleContext(LayoutAttrContext::class.java, i)
        }

        fun viewAttr(): List<ViewAttrContext> {
            return getRuleContexts(ViewAttrContext::class.java)
        }

        fun viewAttr(i: Int): ViewAttrContext {
            return getRuleContext(ViewAttrContext::class.java, i)
        }

        fun tapAttr(): List<TapAttrContext> {
            return getRuleContexts(TapAttrContext::class.java)
        }

        fun tapAttr(i: Int): TapAttrContext {
            return getRuleContext(TapAttrContext::class.java, i)
        }

        fun layoutNode(): List<LayoutNodeContext> {
            return getRuleContexts(LayoutNodeContext::class.java)
        }

        fun layoutNode(i: Int): LayoutNodeContext {
            return getRuleContext(LayoutNodeContext::class.java, i)
        }

        fun node(): List<NodeContext> {
            return getRuleContexts(NodeContext::class.java)
        }

        fun node(i: Int): NodeContext {
            return getRuleContext(NodeContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_row
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterRow(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitRow(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitRow(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun row(): RowContext {
        val _localctx = RowContext(_ctx, state)
        enterRule(_localctx, 46, RULE_row)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 442
                match(ROW)
                state = 443
                match(LEFT_FIGURE_BRACE)
                state = 451
                _errHandler.sync(this)
                _la = _input.LA(1)
                while ((((_la) and 0x3f.inv()) == 0 && ((1L shl _la) and 536609790L) != 0L) || ((((_la - 75)) and 0x3f.inv()) == 0 && ((1L shl (_la - 75)) and 7L) != 0L)) {
                    run {
                        state = 449
                        _errHandler.sync(this)
                        when (_input.LA(1)) {
                            WIDTH, HEIGHT, WEIGHT, GRAVITY, MARGIN -> {
                                state = 444
                                layoutAttr()
                            }

                            TEST_TAG, ALPHA, PADDING, BACKGROUND, IS_ENABLED, IS_VISIBLE -> {
                                state = 445
                                viewAttr()
                            }

                            ON_TAP, ON_LONG_TAP, ON_PRESSED_CHANGE -> {
                                state = 446
                                tapAttr()
                            }

                            BOX, COLUMN, FLOW_ROW, LAZY_COLUMN, LAZY_ROW, ROW -> {
                                state = 447
                                layoutNode()
                            }

                            TEXT_NODE, TEXT_FIELD_NODE, IMAGE_NODE -> {
                                state = 448
                                node()
                            }

                            else -> throw NoViableAltException(this)
                        }
                    }
                    state = 453
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 454
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class FlowRowContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun FLOW_ROW(): TerminalNode {
            return getToken(FLOW_ROW, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun layoutAttr(): List<LayoutAttrContext> {
            return getRuleContexts(LayoutAttrContext::class.java)
        }

        fun layoutAttr(i: Int): LayoutAttrContext {
            return getRuleContext(LayoutAttrContext::class.java, i)
        }

        fun viewAttr(): List<ViewAttrContext> {
            return getRuleContexts(ViewAttrContext::class.java)
        }

        fun viewAttr(i: Int): ViewAttrContext {
            return getRuleContext(ViewAttrContext::class.java, i)
        }

        fun tapAttr(): List<TapAttrContext> {
            return getRuleContexts(TapAttrContext::class.java)
        }

        fun tapAttr(i: Int): TapAttrContext {
            return getRuleContext(TapAttrContext::class.java, i)
        }

        fun flowRowAttr(): List<FlowRowAttrContext> {
            return getRuleContexts(FlowRowAttrContext::class.java)
        }

        fun flowRowAttr(i: Int): FlowRowAttrContext {
            return getRuleContext(FlowRowAttrContext::class.java, i)
        }

        fun layoutNode(): List<LayoutNodeContext> {
            return getRuleContexts(LayoutNodeContext::class.java)
        }

        fun layoutNode(i: Int): LayoutNodeContext {
            return getRuleContext(LayoutNodeContext::class.java, i)
        }

        fun node(): List<NodeContext> {
            return getRuleContexts(NodeContext::class.java)
        }

        fun node(i: Int): NodeContext {
            return getRuleContext(NodeContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_flowRow
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterFlowRow(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitFlowRow(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitFlowRow(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun flowRow(): FlowRowContext {
        val _localctx = FlowRowContext(_ctx, state)
        enterRule(_localctx, 48, RULE_flowRow)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 456
                match(FLOW_ROW)
                state = 457
                match(LEFT_FIGURE_BRACE)
                state = 466
                _errHandler.sync(this)
                _la = _input.LA(1)
                while ((((_la) and 0x3f.inv()) == 0 && ((1L shl _la) and 4035225266660574206L) != 0L) || ((((_la - 75)) and 0x3f.inv()) == 0 && ((1L shl (_la - 75)) and 7L) != 0L)) {
                    run {
                        state = 464
                        _errHandler.sync(this)
                        when (_input.LA(1)) {
                            WIDTH, HEIGHT, WEIGHT, GRAVITY, MARGIN -> {
                                state = 458
                                layoutAttr()
                            }

                            TEST_TAG, ALPHA, PADDING, BACKGROUND, IS_ENABLED, IS_VISIBLE -> {
                                state = 459
                                viewAttr()
                            }

                            ON_TAP, ON_LONG_TAP, ON_PRESSED_CHANGE -> {
                                state = 460
                                tapAttr()
                            }

                            MAX_LINES_COUNT, HORIZONTAL_SPACING, VERTICAL_SPACING -> {
                                state = 461
                                flowRowAttr()
                            }

                            BOX, COLUMN, FLOW_ROW, LAZY_COLUMN, LAZY_ROW, ROW -> {
                                state = 462
                                layoutNode()
                            }

                            TEXT_NODE, TEXT_FIELD_NODE, IMAGE_NODE -> {
                                state = 463
                                node()
                            }

                            else -> throw NoViableAltException(this)
                        }
                    }
                    state = 468
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 469
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class LazyColumnContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun LAZY_COLUMN(): TerminalNode {
            return getToken(LAZY_COLUMN, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun layoutAttr(): List<LayoutAttrContext> {
            return getRuleContexts(LayoutAttrContext::class.java)
        }

        fun layoutAttr(i: Int): LayoutAttrContext {
            return getRuleContext(LayoutAttrContext::class.java, i)
        }

        fun viewAttr(): List<ViewAttrContext> {
            return getRuleContexts(ViewAttrContext::class.java)
        }

        fun viewAttr(i: Int): ViewAttrContext {
            return getRuleContext(ViewAttrContext::class.java, i)
        }

        fun tapAttr(): List<TapAttrContext> {
            return getRuleContexts(TapAttrContext::class.java)
        }

        fun tapAttr(i: Int): TapAttrContext {
            return getRuleContext(TapAttrContext::class.java, i)
        }

        fun item(): List<ItemContext> {
            return getRuleContexts(ItemContext::class.java)
        }

        fun item(i: Int): ItemContext {
            return getRuleContext(ItemContext::class.java, i)
        }

        fun items(): List<ItemsContext> {
            return getRuleContexts(ItemsContext::class.java)
        }

        fun items(i: Int): ItemsContext {
            return getRuleContext(ItemsContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_lazyColumn
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterLazyColumn(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitLazyColumn(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitLazyColumn(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun lazyColumn(): LazyColumnContext {
        val _localctx = LazyColumnContext(_ctx, state)
        enterRule(_localctx, 50, RULE_lazyColumn)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 471
                match(LAZY_COLUMN)
                state = 472
                match(LEFT_FIGURE_BRACE)
                state = 480
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (((((_la - 18)) and 0x3f.inv()) == 0 && ((1L shl (_la - 18)) and 1116892707587885055L) != 0L)) {
                    run {
                        state = 478
                        _errHandler.sync(this)
                        when (_input.LA(1)) {
                            WIDTH, HEIGHT, WEIGHT, GRAVITY, MARGIN -> {
                                state = 473
                                layoutAttr()
                            }

                            TEST_TAG, ALPHA, PADDING, BACKGROUND, IS_ENABLED, IS_VISIBLE -> {
                                state = 474
                                viewAttr()
                            }

                            ON_TAP, ON_LONG_TAP, ON_PRESSED_CHANGE -> {
                                state = 475
                                tapAttr()
                            }

                            ITEM -> {
                                state = 476
                                item()
                            }

                            ITEMS -> {
                                state = 477
                                items()
                            }

                            else -> throw NoViableAltException(this)
                        }
                    }
                    state = 482
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 483
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class LazyRowContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun LAZY_ROW(): TerminalNode {
            return getToken(LAZY_ROW, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun layoutAttr(): List<LayoutAttrContext> {
            return getRuleContexts(LayoutAttrContext::class.java)
        }

        fun layoutAttr(i: Int): LayoutAttrContext {
            return getRuleContext(LayoutAttrContext::class.java, i)
        }

        fun viewAttr(): List<ViewAttrContext> {
            return getRuleContexts(ViewAttrContext::class.java)
        }

        fun viewAttr(i: Int): ViewAttrContext {
            return getRuleContext(ViewAttrContext::class.java, i)
        }

        fun tapAttr(): List<TapAttrContext> {
            return getRuleContexts(TapAttrContext::class.java)
        }

        fun tapAttr(i: Int): TapAttrContext {
            return getRuleContext(TapAttrContext::class.java, i)
        }

        fun item(): List<ItemContext> {
            return getRuleContexts(ItemContext::class.java)
        }

        fun item(i: Int): ItemContext {
            return getRuleContext(ItemContext::class.java, i)
        }

        fun items(): List<ItemsContext> {
            return getRuleContexts(ItemsContext::class.java)
        }

        fun items(i: Int): ItemsContext {
            return getRuleContext(ItemsContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_lazyRow
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterLazyRow(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitLazyRow(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitLazyRow(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun lazyRow(): LazyRowContext {
        val _localctx = LazyRowContext(_ctx, state)
        enterRule(_localctx, 52, RULE_lazyRow)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 485
                match(LAZY_ROW)
                state = 486
                match(LEFT_FIGURE_BRACE)
                state = 494
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (((((_la - 18)) and 0x3f.inv()) == 0 && ((1L shl (_la - 18)) and 1116892707587885055L) != 0L)) {
                    run {
                        state = 492
                        _errHandler.sync(this)
                        when (_input.LA(1)) {
                            WIDTH, HEIGHT, WEIGHT, GRAVITY, MARGIN -> {
                                state = 487
                                layoutAttr()
                            }

                            TEST_TAG, ALPHA, PADDING, BACKGROUND, IS_ENABLED, IS_VISIBLE -> {
                                state = 488
                                viewAttr()
                            }

                            ON_TAP, ON_LONG_TAP, ON_PRESSED_CHANGE -> {
                                state = 489
                                tapAttr()
                            }

                            ITEM -> {
                                state = 490
                                item()
                            }

                            ITEMS -> {
                                state = 491
                                items()
                            }

                            else -> throw NoViableAltException(this)
                        }
                    }
                    state = 496
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 497
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class ItemContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun ITEM(): TerminalNode {
            return getToken(ITEM, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun node(): NodeContext {
            return getRuleContext(NodeContext::class.java, 0)
        }

        fun layoutNode(): LayoutNodeContext {
            return getRuleContext(LayoutNodeContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_item
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterItem(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitItem(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitItem(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun item(): ItemContext {
        val _localctx = ItemContext(_ctx, state)
        enterRule(_localctx, 54, RULE_item)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 499
                match(ITEM)
                state = 500
                match(LEFT_FIGURE_BRACE)
                state = 503
                _errHandler.sync(this)
                when (_input.LA(1)) {
                    TEXT_NODE, TEXT_FIELD_NODE, IMAGE_NODE -> {
                        state = 501
                        node()
                    }

                    BOX, COLUMN, FLOW_ROW, LAZY_COLUMN, LAZY_ROW, ROW -> {
                        state = 502
                        layoutNode()
                    }

                    else -> throw NoViableAltException(this)
                }
                state = 505
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class ItemsContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun ITEMS(): TerminalNode {
            return getToken(ITEMS, 0)
        }

        fun LEFT_BRACE(): TerminalNode {
            return getToken(LEFT_BRACE, 0)
        }

        fun FIELD_NAME(): TerminalNode {
            return getToken(FIELD_NAME, 0)
        }

        fun RIGHT_BRACE(): TerminalNode {
            return getToken(RIGHT_BRACE, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun node(): NodeContext {
            return getRuleContext(NodeContext::class.java, 0)
        }

        fun layoutNode(): LayoutNodeContext {
            return getRuleContext(LayoutNodeContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_items
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterItems(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitItems(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitItems(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun items(): ItemsContext {
        val _localctx = ItemsContext(_ctx, state)
        enterRule(_localctx, 56, RULE_items)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 507
                match(ITEMS)
                state = 508
                match(LEFT_BRACE)
                state = 509
                match(FIELD_NAME)
                state = 510
                match(RIGHT_BRACE)
                state = 511
                match(LEFT_FIGURE_BRACE)
                state = 514
                _errHandler.sync(this)
                when (_input.LA(1)) {
                    TEXT_NODE, TEXT_FIELD_NODE, IMAGE_NODE -> {
                        state = 512
                        node()
                    }

                    BOX, COLUMN, FLOW_ROW, LAZY_COLUMN, LAZY_ROW, ROW -> {
                        state = 513
                        layoutNode()
                    }

                    else -> throw NoViableAltException(this)
                }
                state = 516
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class AttrExpressionContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun ifExpr(): IfExprContext {
            return getRuleContext(IfExprContext::class.java, 0)
        }

        fun fieldExpr(): FieldExprContext {
            return getRuleContext(FieldExprContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_attrExpression
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterAttrExpression(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitAttrExpression(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitAttrExpression(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun attrExpression(): AttrExpressionContext {
        val _localctx = AttrExpressionContext(_ctx, state)
        enterRule(_localctx, 58, RULE_attrExpression)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 520
                _errHandler.sync(this)
                when (_input.LA(1)) {
                    IF_THEN -> {
                        state = 518
                        ifExpr()
                    }

                    FIELD_NAME -> {
                        state = 519
                        fieldExpr()
                    }

                    else -> throw NoViableAltException(this)
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class IfExprContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun IF_THEN(): TerminalNode {
            return getToken(IF_THEN, 0)
        }

        fun LEFT_BRACE(): TerminalNode {
            return getToken(LEFT_BRACE, 0)
        }

        fun condition(): ConditionContext {
            return getRuleContext(ConditionContext::class.java, 0)
        }

        fun COMMA(): TerminalNode {
            return getToken(COMMA, 0)
        }

        fun ifValues(): IfValuesContext {
            return getRuleContext(IfValuesContext::class.java, 0)
        }

        fun RIGHT_BRACE(): TerminalNode {
            return getToken(RIGHT_BRACE, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_ifExpr
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterIfExpr(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitIfExpr(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitIfExpr(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun ifExpr(): IfExprContext {
        val _localctx = IfExprContext(_ctx, state)
        enterRule(_localctx, 60, RULE_ifExpr)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 522
                match(IF_THEN)
                state = 523
                match(LEFT_BRACE)
                state = 524
                condition()
                state = 525
                match(COMMA)
                state = 526
                ifValues()
                state = 527
                match(RIGHT_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class ConditionContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun consts(): ConstsContext {
            return getRuleContext(ConstsContext::class.java, 0)
        }

        fun fieldExpr(): FieldExprContext {
            return getRuleContext(FieldExprContext::class.java, 0)
        }

        fun EQUAL(): TerminalNode {
            return getToken(EQUAL, 0)
        }

        fun NOT_EQUAL(): TerminalNode {
            return getToken(NOT_EQUAL, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_condition
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterCondition(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitCondition(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitCondition(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun condition(): ConditionContext {
        val _localctx = ConditionContext(_ctx, state)
        enterRule(_localctx, 62, RULE_condition)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 529
                consts()
                state = 532
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == EQUAL || _la == NOT_EQUAL) {
                    run {
                        state = 530
                        _la = _input.LA(1)
                        if (!(_la == EQUAL || _la == NOT_EQUAL)) {
                            _errHandler.recoverInline(this)
                        } else {
                            if (_input.LA(1) == Token.EOF) matchedEOF = true
                            _errHandler.reportMatch(this)
                            consume()
                        }
                        state = 531
                        fieldExpr()
                    }
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class ConstsContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun FBOOLEAN(): TerminalNode {
            return getToken(FBOOLEAN, 0)
        }

        fun FLONG(): TerminalNode {
            return getToken(FLONG, 0)
        }

        fun FDOUBLE(): TerminalNode {
            return getToken(FDOUBLE, 0)
        }

        fun FSTRING(): TerminalNode {
            return getToken(FSTRING, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_consts
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterConsts(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitConsts(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitConsts(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun consts(): ConstsContext {
        val _localctx = ConstsContext(_ctx, state)
        enterRule(_localctx, 64, RULE_consts)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 534
                _la = _input.LA(1)
                if (!(((((_la - 142)) and 0x3f.inv()) == 0 && ((1L shl (_la - 142)) and 85L) != 0L))) {
                    _errHandler.recoverInline(this)
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true
                    _errHandler.reportMatch(this)
                    consume()
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class FieldExprContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun FIELD_NAME(): TerminalNode {
            return getToken(FIELD_NAME, 0)
        }

        fun LEFT_SQUARE_BRACE(): TerminalNode {
            return getToken(LEFT_SQUARE_BRACE, 0)
        }

        fun RIGHT_SQUARE_BRACE(): TerminalNode {
            return getToken(RIGHT_SQUARE_BRACE, 0)
        }

        fun STRING(): TerminalNode {
            return getToken(STRING, 0)
        }

        fun LONG(): TerminalNode {
            return getToken(LONG, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_fieldExpr
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterFieldExpr(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitFieldExpr(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitFieldExpr(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun fieldExpr(): FieldExprContext {
        val _localctx = FieldExprContext(_ctx, state)
        enterRule(_localctx, 66, RULE_fieldExpr)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 541
                _errHandler.sync(this)
                when (interpreter.adaptivePredict(_input, 39, _ctx)) {
                    1 -> {
                        state = 536
                        match(FIELD_NAME)
                    }

                    2 -> {
                        state = 537
                        match(FIELD_NAME)
                        state = 538
                        match(LEFT_SQUARE_BRACE)
                        state = 539
                        _la = _input.LA(1)
                        if (!(_la == STRING || _la == LONG)) {
                            _errHandler.recoverInline(this)
                        } else {
                            if (_input.LA(1) == Token.EOF) matchedEOF = true
                            _errHandler.reportMatch(this)
                            consume()
                        }
                        state = 540
                        match(RIGHT_SQUARE_BRACE)
                    }

                    else -> {}
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class IfValuesContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun consts(): List<ConstsContext> {
            return getRuleContexts(ConstsContext::class.java)
        }

        fun consts(i: Int): ConstsContext {
            return getRuleContext(ConstsContext::class.java, i)
        }

        fun fieldExpr(): List<FieldExprContext> {
            return getRuleContexts(FieldExprContext::class.java)
        }

        fun fieldExpr(i: Int): FieldExprContext {
            return getRuleContext(FieldExprContext::class.java, i)
        }

        fun COMMA(): TerminalNode {
            return getToken(COMMA, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_ifValues
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterIfValues(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitIfValues(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitIfValues(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun ifValues(): IfValuesContext {
        val _localctx = IfValuesContext(_ctx, state)
        enterRule(_localctx, 68, RULE_ifValues)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 545
                _errHandler.sync(this)
                when (_input.LA(1)) {
                    FSTRING, FBOOLEAN, FDOUBLE, FLONG -> {
                        state = 543
                        consts()
                    }

                    FIELD_NAME -> {
                        state = 544
                        fieldExpr()
                    }

                    else -> throw NoViableAltException(this)
                }
                state = 552
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == COMMA) {
                    run {
                        state = 547
                        match(COMMA)
                        state = 550
                        _errHandler.sync(this)
                        when (_input.LA(1)) {
                            FSTRING, FBOOLEAN, FDOUBLE, FLONG -> {
                                state = 548
                                consts()
                            }

                            FIELD_NAME -> {
                                state = 549
                                fieldExpr()
                            }

                            else -> throw NoViableAltException(this)
                        }
                    }
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class LayoutAttrContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun width(): WidthContext {
            return getRuleContext(WidthContext::class.java, 0)
        }

        fun height(): HeightContext {
            return getRuleContext(HeightContext::class.java, 0)
        }

        fun weight(): WeightContext {
            return getRuleContext(WeightContext::class.java, 0)
        }

        fun gravity(): GravityContext {
            return getRuleContext(GravityContext::class.java, 0)
        }

        fun margin(): MarginContext {
            return getRuleContext(MarginContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_layoutAttr
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterLayoutAttr(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitLayoutAttr(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitLayoutAttr(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun layoutAttr(): LayoutAttrContext {
        val _localctx = LayoutAttrContext(_ctx, state)
        enterRule(_localctx, 70, RULE_layoutAttr)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 559
                _errHandler.sync(this)
                when (_input.LA(1)) {
                    WIDTH -> {
                        state = 554
                        width()
                    }

                    HEIGHT -> {
                        state = 555
                        height()
                    }

                    WEIGHT -> {
                        state = 556
                        weight()
                    }

                    GRAVITY -> {
                        state = 557
                        gravity()
                    }

                    MARGIN -> {
                        state = 558
                        margin()
                    }

                    else -> throw NoViableAltException(this)
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class WidthContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun WIDTH(): TerminalNode {
            return getToken(WIDTH, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun dimension(): DimensionContext {
            return getRuleContext(DimensionContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_width
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterWidth(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitWidth(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitWidth(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun width(): WidthContext {
        val _localctx = WidthContext(_ctx, state)
        enterRule(_localctx, 72, RULE_width)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 561
                match(WIDTH)
                state = 562
                match(LEFT_FIGURE_BRACE)
                run {
                    state = 563
                    dimension()
                }
                state = 564
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class HeightContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun HEIGHT(): TerminalNode {
            return getToken(HEIGHT, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun dimension(): DimensionContext {
            return getRuleContext(DimensionContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_height
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterHeight(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitHeight(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitHeight(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun height(): HeightContext {
        val _localctx = HeightContext(_ctx, state)
        enterRule(_localctx, 74, RULE_height)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 566
                match(HEIGHT)
                state = 567
                match(LEFT_FIGURE_BRACE)
                run {
                    state = 568
                    dimension()
                }
                state = 569
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class WeightContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun WEIGHT(): TerminalNode {
            return getToken(WEIGHT, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun FDOUBLE(): TerminalNode {
            return getToken(FDOUBLE, 0)
        }

        fun attrExpression(): AttrExpressionContext {
            return getRuleContext(AttrExpressionContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_weight
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterWeight(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitWeight(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitWeight(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun weight(): WeightContext {
        val _localctx = WeightContext(_ctx, state)
        enterRule(_localctx, 76, RULE_weight)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 571
                match(WEIGHT)
                state = 572
                match(LEFT_FIGURE_BRACE)
                state = 575
                _errHandler.sync(this)
                when (_input.LA(1)) {
                    FDOUBLE -> {
                        state = 573
                        match(FDOUBLE)
                    }

                    IF_THEN, FIELD_NAME -> {
                        state = 574
                        attrExpression()
                    }

                    else -> throw NoViableAltException(this)
                }
                state = 577
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class GravityContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun GRAVITY(): TerminalNode {
            return getToken(GRAVITY, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun gravityExpression(): GravityExpressionContext {
            return getRuleContext(GravityExpressionContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_gravity
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterGravity(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitGravity(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitGravity(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun gravity(): GravityContext {
        val _localctx = GravityContext(_ctx, state)
        enterRule(_localctx, 78, RULE_gravity)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 579
                match(GRAVITY)
                state = 580
                match(LEFT_FIGURE_BRACE)
                run {
                    state = 581
                    gravityExpression()
                }
                state = 582
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class GravityExpressionContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun gravityValue(): GravityValueContext {
            return getRuleContext(GravityValueContext::class.java, 0)
        }

        fun PLUS(): TerminalNode {
            return getToken(PLUS, 0)
        }

        fun gravityExpression(): GravityExpressionContext {
            return getRuleContext(GravityExpressionContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_gravityExpression
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterGravityExpression(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitGravityExpression(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitGravityExpression(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun gravityExpression(): GravityExpressionContext {
        val _localctx = GravityExpressionContext(_ctx, state)
        enterRule(_localctx, 80, RULE_gravityExpression)
        try {
            state = 589
            _errHandler.sync(this)
            when (interpreter.adaptivePredict(_input, 45, _ctx)) {
                1 -> {
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 584
                        gravityValue()
                    }
                }

                2 -> {
                    enterOuterAlt(_localctx, 2)
                    run {
                        run {
                            state = 585
                            gravityValue()
                            state = 586
                            match(PLUS)
                            state = 587
                            gravityExpression()
                        }
                    }
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class GravityValueContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun CENTER(): TerminalNode {
            return getToken(CENTER, 0)
        }

        fun LEFT(): TerminalNode {
            return getToken(LEFT, 0)
        }

        fun RIGHT(): TerminalNode {
            return getToken(RIGHT, 0)
        }

        fun TOP(): TerminalNode {
            return getToken(TOP, 0)
        }

        fun BOTTOM(): TerminalNode {
            return getToken(BOTTOM, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_gravityValue
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterGravityValue(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitGravityValue(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitGravityValue(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun gravityValue(): GravityValueContext {
        val _localctx = GravityValueContext(_ctx, state)
        enterRule(_localctx, 82, RULE_gravityValue)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 591
                _la = _input.LA(1)
                if (!(((((_la - 100)) and 0x3f.inv()) == 0 && ((1L shl (_la - 100)) and 31L) != 0L))) {
                    _errHandler.recoverInline(this)
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true
                    _errHandler.reportMatch(this)
                    consume()
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class MarginContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun MARGIN(): TerminalNode {
            return getToken(MARGIN, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun insets(): List<InsetsContext> {
            return getRuleContexts(InsetsContext::class.java)
        }

        fun insets(i: Int): InsetsContext {
            return getRuleContext(InsetsContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_margin
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterMargin(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitMargin(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitMargin(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun margin(): MarginContext {
        val _localctx = MarginContext(_ctx, state)
        enterRule(_localctx, 84, RULE_margin)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 593
                match(MARGIN)
                state = 594
                match(LEFT_FIGURE_BRACE)
                run {
                    state = 598
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                    while (((((_la - 101)) and 0x3f.inv()) == 0 && ((1L shl (_la - 101)) and 6415L) != 0L)) {
                        run {
                            run {
                                state = 595
                                insets()
                            }
                        }
                        state = 600
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                    }
                }
                state = 601
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class InsetsContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun insetsName(): InsetsNameContext {
            return getRuleContext(InsetsNameContext::class.java, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun exact(): ExactContext {
            return getRuleContext(ExactContext::class.java, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_insets
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterInsets(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitInsets(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitInsets(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun insets(): InsetsContext {
        val _localctx = InsetsContext(_ctx, state)
        enterRule(_localctx, 86, RULE_insets)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 603
                insetsName()
                state = 604
                match(LEFT_FIGURE_BRACE)
                state = 605
                exact()
                state = 606
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class InsetsNameContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun LEFT(): TerminalNode {
            return getToken(LEFT, 0)
        }

        fun RIGHT(): TerminalNode {
            return getToken(RIGHT, 0)
        }

        fun TOP(): TerminalNode {
            return getToken(TOP, 0)
        }

        fun BOTTOM(): TerminalNode {
            return getToken(BOTTOM, 0)
        }

        fun HORIZONTAL(): TerminalNode {
            return getToken(HORIZONTAL, 0)
        }

        fun VERTICAL(): TerminalNode {
            return getToken(VERTICAL, 0)
        }

        fun ALL(): TerminalNode {
            return getToken(ALL, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_insetsName
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterInsetsName(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitInsetsName(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitInsetsName(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun insetsName(): InsetsNameContext {
        val _localctx = InsetsNameContext(_ctx, state)
        enterRule(_localctx, 88, RULE_insetsName)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 608
                _la = _input.LA(1)
                if (!(((((_la - 101)) and 0x3f.inv()) == 0 && ((1L shl (_la - 101)) and 6415L) != 0L))) {
                    _errHandler.recoverInline(this)
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true
                    _errHandler.reportMatch(this)
                    consume()
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class DimensionContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun match(): MatchContext {
            return getRuleContext(MatchContext::class.java, 0)
        }

        fun exact(): ExactContext {
            return getRuleContext(ExactContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_dimension
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterDimension(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitDimension(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitDimension(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun dimension(): DimensionContext {
        val _localctx = DimensionContext(_ctx, state)
        enterRule(_localctx, 90, RULE_dimension)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 612
                _errHandler.sync(this)
                when (_input.LA(1)) {
                    FILL, WRAP -> {
                        state = 610
                        match()
                    }

                    DOUBLE, LONG -> {
                        state = 611
                        exact()
                    }

                    else -> throw NoViableAltException(this)
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class MatchContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun FILL(): TerminalNode {
            return getToken(FILL, 0)
        }

        fun WRAP(): TerminalNode {
            return getToken(WRAP, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_match
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterMatch(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitMatch(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitMatch(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun match(): MatchContext {
        val _localctx = MatchContext(_ctx, state)
        enterRule(_localctx, 92, RULE_match)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 614
                _la = _input.LA(1)
                if (!(_la == FILL || _la == WRAP)) {
                    _errHandler.recoverInline(this)
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true
                    _errHandler.reportMatch(this)
                    consume()
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class ExactContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun POINT(): TerminalNode {
            return getToken(POINT, 0)
        }

        fun DOUBLE(): TerminalNode {
            return getToken(DOUBLE, 0)
        }

        fun LONG(): TerminalNode {
            return getToken(LONG, 0)
        }

        fun NP(): TerminalNode {
            return getToken(NP, 0)
        }

        fun AP(): TerminalNode {
            return getToken(AP, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_exact
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterExact(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitExact(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitExact(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun exact(): ExactContext {
        val _localctx = ExactContext(_ctx, state)
        enterRule(_localctx, 94, RULE_exact)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 616
                _la = _input.LA(1)
                if (!(_la == DOUBLE || _la == LONG)) {
                    _errHandler.recoverInline(this)
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true
                    _errHandler.reportMatch(this)
                    consume()
                }
                state = 617
                match(POINT)
                state = 618
                _la = _input.LA(1)
                if (!(_la == NP || _la == AP)) {
                    _errHandler.recoverInline(this)
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true
                    _errHandler.reportMatch(this)
                    consume()
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class ViewAttrContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun testTag(): TestTagContext {
            return getRuleContext(TestTagContext::class.java, 0)
        }

        fun alpha(): AlphaContext {
            return getRuleContext(AlphaContext::class.java, 0)
        }

        fun padding(): PaddingContext {
            return getRuleContext(PaddingContext::class.java, 0)
        }

        fun background(): BackgroundContext {
            return getRuleContext(BackgroundContext::class.java, 0)
        }

        val isEnabled: IsEnabledContext
            get() = getRuleContext(IsEnabledContext::class.java, 0)
        val isVisible: IsVisibleContext
            get() = getRuleContext(IsVisibleContext::class.java, 0)

        override fun getRuleIndex(): Int {
            return RULE_viewAttr
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterViewAttr(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitViewAttr(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitViewAttr(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun viewAttr(): ViewAttrContext {
        val _localctx = ViewAttrContext(_ctx, state)
        enterRule(_localctx, 96, RULE_viewAttr)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 626
                _errHandler.sync(this)
                when (_input.LA(1)) {
                    TEST_TAG -> {
                        state = 620
                        testTag()
                    }

                    ALPHA -> {
                        state = 621
                        alpha()
                    }

                    PADDING -> {
                        state = 622
                        padding()
                    }

                    BACKGROUND -> {
                        state = 623
                        background()
                    }

                    IS_ENABLED -> {
                        state = 624
                        this.isEnabled
                    }

                    IS_VISIBLE -> {
                        state = 625
                        this.isVisible
                    }

                    else -> throw NoViableAltException(this)
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class TestTagContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun TEST_TAG(): TerminalNode {
            return getToken(TEST_TAG, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun FSTRING(): TerminalNode {
            return getToken(FSTRING, 0)
        }

        fun attrExpression(): AttrExpressionContext {
            return getRuleContext(AttrExpressionContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_testTag
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterTestTag(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitTestTag(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitTestTag(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun testTag(): TestTagContext {
        val _localctx = TestTagContext(_ctx, state)
        enterRule(_localctx, 98, RULE_testTag)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 628
                match(TEST_TAG)
                state = 629
                match(LEFT_FIGURE_BRACE)
                state = 632
                _errHandler.sync(this)
                when (_input.LA(1)) {
                    FSTRING -> {
                        state = 630
                        match(FSTRING)
                    }

                    IF_THEN, FIELD_NAME -> {
                        state = 631
                        attrExpression()
                    }

                    else -> throw NoViableAltException(this)
                }
                state = 634
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class AlphaContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun ALPHA(): TerminalNode {
            return getToken(ALPHA, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun FDOUBLE(): TerminalNode {
            return getToken(FDOUBLE, 0)
        }

        fun attrExpression(): AttrExpressionContext {
            return getRuleContext(AttrExpressionContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_alpha
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterAlpha(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitAlpha(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitAlpha(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun alpha(): AlphaContext {
        val _localctx = AlphaContext(_ctx, state)
        enterRule(_localctx, 100, RULE_alpha)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 636
                match(ALPHA)
                state = 637
                match(LEFT_FIGURE_BRACE)
                state = 640
                _errHandler.sync(this)
                when (_input.LA(1)) {
                    FDOUBLE -> {
                        state = 638
                        match(FDOUBLE)
                    }

                    IF_THEN, FIELD_NAME -> {
                        state = 639
                        attrExpression()
                    }

                    else -> throw NoViableAltException(this)
                }
                state = 642
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class PaddingContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun PADDING(): TerminalNode {
            return getToken(PADDING, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun insets(): List<InsetsContext> {
            return getRuleContexts(InsetsContext::class.java)
        }

        fun insets(i: Int): InsetsContext {
            return getRuleContext(InsetsContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_padding
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterPadding(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitPadding(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitPadding(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun padding(): PaddingContext {
        val _localctx = PaddingContext(_ctx, state)
        enterRule(_localctx, 102, RULE_padding)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 644
                match(PADDING)
                state = 645
                match(LEFT_FIGURE_BRACE)
                state = 649
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (((((_la - 101)) and 0x3f.inv()) == 0 && ((1L shl (_la - 101)) and 6415L) != 0L)) {
                    run {
                        run {
                            state = 646
                            insets()
                        }
                    }
                    state = 651
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 652
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class BackgroundContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun BACKGROUND(): TerminalNode {
            return getToken(BACKGROUND, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun backgroundValue(): List<BackgroundValueContext> {
            return getRuleContexts(BackgroundValueContext::class.java)
        }

        fun backgroundValue(i: Int): BackgroundValueContext {
            return getRuleContext(BackgroundValueContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_background
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterBackground(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitBackground(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitBackground(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun background(): BackgroundContext {
        val _localctx = BackgroundContext(_ctx, state)
        enterRule(_localctx, 104, RULE_background)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 654
                match(BACKGROUND)
                state = 655
                match(LEFT_FIGURE_BRACE)
                state = 659
                _errHandler.sync(this)
                _la = _input.LA(1)
                while ((((_la) and 0x3f.inv()) == 0 && ((1L shl _la) and 3758096384L) != 0L)) {
                    run {
                        run {
                            state = 656
                            backgroundValue()
                        }
                    }
                    state = 661
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 662
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class BackgroundValueContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun border(): BorderContext {
            return getRuleContext(BorderContext::class.java, 0)
        }

        fun cornersRadius(): CornersRadiusContext {
            return getRuleContext(CornersRadiusContext::class.java, 0)
        }

        fun color(): ColorContext {
            return getRuleContext(ColorContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_backgroundValue
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterBackgroundValue(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitBackgroundValue(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitBackgroundValue(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun backgroundValue(): BackgroundValueContext {
        val _localctx = BackgroundValueContext(_ctx, state)
        enterRule(_localctx, 106, RULE_backgroundValue)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 667
                _errHandler.sync(this)
                when (_input.LA(1)) {
                    BORDER -> {
                        state = 664
                        border()
                    }

                    CORNERS_RADIUS -> {
                        state = 665
                        cornersRadius()
                    }

                    COLOR -> {
                        state = 666
                        color()
                    }

                    else -> throw NoViableAltException(this)
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class BorderContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun BORDER(): TerminalNode {
            return getToken(BORDER, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun borderAttr(): List<BorderAttrContext> {
            return getRuleContexts(BorderAttrContext::class.java)
        }

        fun borderAttr(i: Int): BorderAttrContext {
            return getRuleContext(BorderAttrContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_border
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterBorder(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitBorder(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitBorder(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun border(): BorderContext {
        val _localctx = BorderContext(_ctx, state)
        enterRule(_localctx, 108, RULE_border)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 669
                match(BORDER)
                state = 670
                match(LEFT_FIGURE_BRACE)
                state = 674
                _errHandler.sync(this)
                _la = _input.LA(1)
                while ((((_la) and 0x3f.inv()) == 0 && ((1L shl _la) and 15032647680L) != 0L)) {
                    run {
                        run {
                            state = 671
                            borderAttr()
                        }
                    }
                    state = 676
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 677
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class BorderAttrContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun widthExact(): WidthExactContext {
            return getRuleContext(WidthExactContext::class.java, 0)
        }

        fun color(): ColorContext {
            return getRuleContext(ColorContext::class.java, 0)
        }

        fun dashSize(): DashSizeContext {
            return getRuleContext(DashSizeContext::class.java, 0)
        }

        fun dashGap(): DashGapContext {
            return getRuleContext(DashGapContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_borderAttr
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterBorderAttr(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitBorderAttr(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitBorderAttr(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun borderAttr(): BorderAttrContext {
        val _localctx = BorderAttrContext(_ctx, state)
        enterRule(_localctx, 110, RULE_borderAttr)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 683
                _errHandler.sync(this)
                when (_input.LA(1)) {
                    WIDTH -> {
                        state = 679
                        widthExact()
                    }

                    COLOR -> {
                        state = 680
                        color()
                    }

                    DASH_SIZE -> {
                        state = 681
                        dashSize()
                    }

                    DASH_GAP -> {
                        state = 682
                        dashGap()
                    }

                    else -> throw NoViableAltException(this)
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class WidthExactContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun WIDTH(): TerminalNode {
            return getToken(WIDTH, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun exact(): ExactContext {
            return getRuleContext(ExactContext::class.java, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_widthExact
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterWidthExact(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitWidthExact(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitWidthExact(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun widthExact(): WidthExactContext {
        val _localctx = WidthExactContext(_ctx, state)
        enterRule(_localctx, 112, RULE_widthExact)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 685
                match(WIDTH)
                state = 686
                match(LEFT_FIGURE_BRACE)
                state = 687
                exact()
                state = 688
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class DashSizeContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun DASH_SIZE(): TerminalNode {
            return getToken(DASH_SIZE, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun exact(): ExactContext {
            return getRuleContext(ExactContext::class.java, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_dashSize
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterDashSize(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitDashSize(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitDashSize(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun dashSize(): DashSizeContext {
        val _localctx = DashSizeContext(_ctx, state)
        enterRule(_localctx, 114, RULE_dashSize)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 690
                match(DASH_SIZE)
                state = 691
                match(LEFT_FIGURE_BRACE)
                state = 692
                exact()
                state = 693
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class DashGapContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun DASH_GAP(): TerminalNode {
            return getToken(DASH_GAP, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun exact(): ExactContext {
            return getRuleContext(ExactContext::class.java, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_dashGap
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterDashGap(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitDashGap(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitDashGap(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun dashGap(): DashGapContext {
        val _localctx = DashGapContext(_ctx, state)
        enterRule(_localctx, 116, RULE_dashGap)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 695
                match(DASH_GAP)
                state = 696
                match(LEFT_FIGURE_BRACE)
                state = 697
                exact()
                state = 698
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class CornersRadiusContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun CORNERS_RADIUS(): TerminalNode {
            return getToken(CORNERS_RADIUS, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun corners(): List<CornersContext> {
            return getRuleContexts(CornersContext::class.java)
        }

        fun corners(i: Int): CornersContext {
            return getRuleContext(CornersContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_cornersRadius
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterCornersRadius(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitCornersRadius(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitCornersRadius(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun cornersRadius(): CornersRadiusContext {
        val _localctx = CornersRadiusContext(_ctx, state)
        enterRule(_localctx, 118, RULE_cornersRadius)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 700
                match(CORNERS_RADIUS)
                state = 701
                match(LEFT_FIGURE_BRACE)
                state = 705
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (((((_la - 105)) and 0x3f.inv()) == 0 && ((1L shl (_la - 105)) and 31L) != 0L)) {
                    run {
                        run {
                            state = 702
                            corners()
                        }
                    }
                    state = 707
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 708
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class CornersContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun cornerName(): CornerNameContext {
            return getRuleContext(CornerNameContext::class.java, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun exact(): ExactContext {
            return getRuleContext(ExactContext::class.java, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_corners
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterCorners(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitCorners(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitCorners(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun corners(): CornersContext {
        val _localctx = CornersContext(_ctx, state)
        enterRule(_localctx, 120, RULE_corners)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 710
                cornerName()
                state = 711
                match(LEFT_FIGURE_BRACE)
                state = 712
                exact()
                state = 713
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class CornerNameContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun LEFT_TOP(): TerminalNode {
            return getToken(LEFT_TOP, 0)
        }

        fun RIGHT_TOP(): TerminalNode {
            return getToken(RIGHT_TOP, 0)
        }

        fun LEFT_BOTTOM(): TerminalNode {
            return getToken(LEFT_BOTTOM, 0)
        }

        fun RIGHT_BOTTOM(): TerminalNode {
            return getToken(RIGHT_BOTTOM, 0)
        }

        fun ALL(): TerminalNode {
            return getToken(ALL, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_cornerName
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterCornerName(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitCornerName(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitCornerName(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun cornerName(): CornerNameContext {
        val _localctx = CornerNameContext(_ctx, state)
        enterRule(_localctx, 122, RULE_cornerName)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 715
                _la = _input.LA(1)
                if (!(((((_la - 105)) and 0x3f.inv()) == 0 && ((1L shl (_la - 105)) and 31L) != 0L))) {
                    _errHandler.recoverInline(this)
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true
                    _errHandler.reportMatch(this)
                    consume()
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class ColorContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun COLOR(): TerminalNode {
            return getToken(COLOR, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun colorHEX(): ColorHEXContext {
            return getRuleContext(ColorHEXContext::class.java, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_color
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterColor(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitColor(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitColor(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun color(): ColorContext {
        val _localctx = ColorContext(_ctx, state)
        enterRule(_localctx, 124, RULE_color)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 717
                match(COLOR)
                state = 718
                match(LEFT_FIGURE_BRACE)
                state = 719
                colorHEX()
                state = 720
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class ColorHEXContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun COLOR(): TerminalNode {
            return getToken(COLOR, 0)
        }

        fun LEFT_BRACE(): TerminalNode {
            return getToken(LEFT_BRACE, 0)
        }

        fun RIGHT_BRACE(): TerminalNode {
            return getToken(RIGHT_BRACE, 0)
        }

        fun HEX(): TerminalNode {
            return getToken(HEX, 0)
        }

        fun attrExpression(): AttrExpressionContext {
            return getRuleContext(AttrExpressionContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_colorHEX
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterColorHEX(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitColorHEX(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitColorHEX(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun colorHEX(): ColorHEXContext {
        val _localctx = ColorHEXContext(_ctx, state)
        enterRule(_localctx, 126, RULE_colorHEX)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 722
                match(COLOR)
                state = 723
                match(LEFT_BRACE)
                state = 726
                _errHandler.sync(this)
                when (_input.LA(1)) {
                    HEX -> {
                        state = 724
                        match(HEX)
                    }

                    IF_THEN, FIELD_NAME -> {
                        state = 725
                        attrExpression()
                    }

                    else -> throw NoViableAltException(this)
                }
                state = 728
                match(RIGHT_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class IsEnabledContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun IS_ENABLED(): TerminalNode {
            return getToken(IS_ENABLED, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun FBOOLEAN(): TerminalNode {
            return getToken(FBOOLEAN, 0)
        }

        fun attrExpression(): AttrExpressionContext {
            return getRuleContext(AttrExpressionContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_isEnabled
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterIsEnabled(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitIsEnabled(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitIsEnabled(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @get:Throws(RecognitionException::class)
    val isEnabled: IsEnabledContext
        get() {
            val _localctx = IsEnabledContext(_ctx, state)
            enterRule(_localctx, 128, RULE_isEnabled)
            try {
                enterOuterAlt(_localctx, 1)
                run {
                    state = 730
                    match(IS_ENABLED)
                    state = 731
                    match(LEFT_FIGURE_BRACE)
                    state = 734
                    _errHandler.sync(this)
                    when (_input.LA(1)) {
                        FBOOLEAN -> {
                            state = 732
                            match(FBOOLEAN)
                        }

                        IF_THEN, FIELD_NAME -> {
                            state = 733
                            attrExpression()
                        }

                        else -> throw NoViableAltException(this)
                    }
                    state = 736
                    match(RIGHT_FIGURE_BRACE)
                }
            } catch (re: RecognitionException) {
                _localctx.exception = re
                _errHandler.reportError(this, re)
                _errHandler.recover(this, re)
            } finally {
                exitRule()
            }
            return _localctx
        }

    class IsVisibleContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun IS_VISIBLE(): TerminalNode {
            return getToken(IS_VISIBLE, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun FBOOLEAN(): TerminalNode {
            return getToken(FBOOLEAN, 0)
        }

        fun attrExpression(): AttrExpressionContext {
            return getRuleContext(AttrExpressionContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_isVisible
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterIsVisible(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitIsVisible(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitIsVisible(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @get:Throws(RecognitionException::class)
    val isVisible: IsVisibleContext
        get() {
            val _localctx = IsVisibleContext(_ctx, state)
            enterRule(_localctx, 130, RULE_isVisible)
            try {
                enterOuterAlt(_localctx, 1)
                run {
                    state = 738
                    match(IS_VISIBLE)
                    state = 739
                    match(LEFT_FIGURE_BRACE)
                    state = 742
                    _errHandler.sync(this)
                    when (_input.LA(1)) {
                        FBOOLEAN -> {
                            state = 740
                            match(FBOOLEAN)
                        }

                        IF_THEN, FIELD_NAME -> {
                            state = 741
                            attrExpression()
                        }

                        else -> throw NoViableAltException(this)
                    }
                    state = 744
                    match(RIGHT_FIGURE_BRACE)
                }
            } catch (re: RecognitionException) {
                _localctx.exception = re
                _errHandler.reportError(this, re)
                _errHandler.recover(this, re)
            } finally {
                exitRule()
            }
            return _localctx
        }

    class TapAttrContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun onTap(): OnTapContext {
            return getRuleContext(OnTapContext::class.java, 0)
        }

        fun onLongTap(): OnLongTapContext {
            return getRuleContext(OnLongTapContext::class.java, 0)
        }

        fun onPressedChange(): OnPressedChangeContext {
            return getRuleContext(OnPressedChangeContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_tapAttr
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterTapAttr(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitTapAttr(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitTapAttr(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun tapAttr(): TapAttrContext {
        val _localctx = TapAttrContext(_ctx, state)
        enterRule(_localctx, 132, RULE_tapAttr)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 749
                _errHandler.sync(this)
                when (_input.LA(1)) {
                    ON_TAP -> {
                        state = 746
                        onTap()
                    }

                    ON_LONG_TAP -> {
                        state = 747
                        onLongTap()
                    }

                    ON_PRESSED_CHANGE -> {
                        state = 748
                        onPressedChange()
                    }

                    else -> throw NoViableAltException(this)
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class OnTapContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun ON_TAP(): TerminalNode {
            return getToken(ON_TAP, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun tapExpression(): List<TapExpressionContext> {
            return getRuleContexts(TapExpressionContext::class.java)
        }

        fun tapExpression(i: Int): TapExpressionContext {
            return getRuleContext(TapExpressionContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_onTap
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterOnTap(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitOnTap(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitOnTap(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun onTap(): OnTapContext {
        val _localctx = OnTapContext(_ctx, state)
        enterRule(_localctx, 134, RULE_onTap)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 751
                match(ON_TAP)
                state = 752
                match(LEFT_FIGURE_BRACE)
                state = 754
                _errHandler.sync(this)
                _la = _input.LA(1)
                do {
                    run {
                        run {
                            state = 753
                            tapExpression()
                        }
                    }
                    state = 756
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                } while (_la == FIELD_NAME)
                state = 758
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class OnLongTapContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun ON_LONG_TAP(): TerminalNode {
            return getToken(ON_LONG_TAP, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun tapExpression(): List<TapExpressionContext> {
            return getRuleContexts(TapExpressionContext::class.java)
        }

        fun tapExpression(i: Int): TapExpressionContext {
            return getRuleContext(TapExpressionContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_onLongTap
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterOnLongTap(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitOnLongTap(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitOnLongTap(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun onLongTap(): OnLongTapContext {
        val _localctx = OnLongTapContext(_ctx, state)
        enterRule(_localctx, 136, RULE_onLongTap)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 760
                match(ON_LONG_TAP)
                state = 761
                match(LEFT_FIGURE_BRACE)
                state = 763
                _errHandler.sync(this)
                _la = _input.LA(1)
                do {
                    run {
                        run {
                            state = 762
                            tapExpression()
                        }
                    }
                    state = 765
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                } while (_la == FIELD_NAME)
                state = 767
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class OnPressedChangeContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun ON_PRESSED_CHANGE(): TerminalNode {
            return getToken(ON_PRESSED_CHANGE, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun tapExpression(): List<TapExpressionContext> {
            return getRuleContexts(TapExpressionContext::class.java)
        }

        fun tapExpression(i: Int): TapExpressionContext {
            return getRuleContext(TapExpressionContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_onPressedChange
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterOnPressedChange(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitOnPressedChange(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitOnPressedChange(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun onPressedChange(): OnPressedChangeContext {
        val _localctx = OnPressedChangeContext(_ctx, state)
        enterRule(_localctx, 138, RULE_onPressedChange)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 769
                match(ON_PRESSED_CHANGE)
                state = 770
                match(LEFT_FIGURE_BRACE)
                state = 772
                _errHandler.sync(this)
                _la = _input.LA(1)
                do {
                    run {
                        run {
                            state = 771
                            tapExpression()
                        }
                    }
                    state = 774
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                } while (_la == FIELD_NAME)
                state = 776
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class TapExpressionContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun FIELD_NAME(): TerminalNode {
            return getToken(FIELD_NAME, 0)
        }

        fun ASSIGN(): TerminalNode {
            return getToken(ASSIGN, 0)
        }

        fun ifExpr(): IfExprContext {
            return getRuleContext(IfExprContext::class.java, 0)
        }

        fun mapExpr(): MapExprContext {
            return getRuleContext(MapExprContext::class.java, 0)
        }

        fun filterExpr(): FilterExprContext {
            return getRuleContext(FilterExprContext::class.java, 0)
        }

        fun consts(): ConstsContext {
            return getRuleContext(ConstsContext::class.java, 0)
        }

        fun fieldExpr(): FieldExprContext {
            return getRuleContext(FieldExprContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_tapExpression
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterTapExpression(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitTapExpression(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitTapExpression(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun tapExpression(): TapExpressionContext {
        val _localctx = TapExpressionContext(_ctx, state)
        enterRule(_localctx, 140, RULE_tapExpression)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 778
                match(FIELD_NAME)
                state = 779
                match(ASSIGN)
                state = 785
                _errHandler.sync(this)
                when (interpreter.adaptivePredict(_input, 64, _ctx)) {
                    1 -> {
                        state = 780
                        ifExpr()
                    }

                    2 -> {
                        state = 781
                        mapExpr()
                    }

                    3 -> {
                        state = 782
                        filterExpr()
                    }

                    4 -> {
                        state = 783
                        consts()
                    }

                    5 -> {
                        state = 784
                        fieldExpr()
                    }

                    else -> {}
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class MapExprContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun FIELD_NAME(): TerminalNode {
            return getToken(FIELD_NAME, 0)
        }

        fun POINT(): TerminalNode {
            return getToken(POINT, 0)
        }

        fun MAP(): TerminalNode {
            return getToken(MAP, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun lambdaParams(): LambdaParamsContext {
            return getRuleContext(LambdaParamsContext::class.java, 0)
        }

        fun ARROW(): TerminalNode {
            return getToken(ARROW, 0)
        }

        fun condition(): ConditionContext {
            return getRuleContext(ConditionContext::class.java, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun LEFT_SQUARE_BRACE(): TerminalNode {
            return getToken(LEFT_SQUARE_BRACE, 0)
        }

        fun RIGHT_SQUARE_BRACE(): TerminalNode {
            return getToken(RIGHT_SQUARE_BRACE, 0)
        }

        fun STRING(): TerminalNode {
            return getToken(STRING, 0)
        }

        fun LONG(): TerminalNode {
            return getToken(LONG, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_mapExpr
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterMapExpr(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitMapExpr(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitMapExpr(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun mapExpr(): MapExprContext {
        val _localctx = MapExprContext(_ctx, state)
        enterRule(_localctx, 142, RULE_mapExpr)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 787
                match(FIELD_NAME)
                state = 788
                match(POINT)
                state = 789
                match(MAP)
                state = 790
                match(LEFT_FIGURE_BRACE)
                state = 791
                lambdaParams()
                state = 792
                match(ARROW)
                state = 793
                condition()
                state = 794
                match(RIGHT_FIGURE_BRACE)
                state = 798
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == LEFT_SQUARE_BRACE) {
                    run {
                        state = 795
                        match(LEFT_SQUARE_BRACE)
                        state = 796
                        _la = _input.LA(1)
                        if (!(_la == STRING || _la == LONG)) {
                            _errHandler.recoverInline(this)
                        } else {
                            if (_input.LA(1) == Token.EOF) matchedEOF = true
                            _errHandler.reportMatch(this)
                            consume()
                        }
                        state = 797
                        match(RIGHT_SQUARE_BRACE)
                    }
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class FilterExprContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun FIELD_NAME(): TerminalNode {
            return getToken(FIELD_NAME, 0)
        }

        fun POINT(): TerminalNode {
            return getToken(POINT, 0)
        }

        fun FILTER(): TerminalNode {
            return getToken(FILTER, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun lambdaParams(): LambdaParamsContext {
            return getRuleContext(LambdaParamsContext::class.java, 0)
        }

        fun ARROW(): TerminalNode {
            return getToken(ARROW, 0)
        }

        fun condition(): ConditionContext {
            return getRuleContext(ConditionContext::class.java, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun LEFT_SQUARE_BRACE(): TerminalNode {
            return getToken(LEFT_SQUARE_BRACE, 0)
        }

        fun RIGHT_SQUARE_BRACE(): TerminalNode {
            return getToken(RIGHT_SQUARE_BRACE, 0)
        }

        fun STRING(): TerminalNode {
            return getToken(STRING, 0)
        }

        fun LONG(): TerminalNode {
            return getToken(LONG, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_filterExpr
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterFilterExpr(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitFilterExpr(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitFilterExpr(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun filterExpr(): FilterExprContext {
        val _localctx = FilterExprContext(_ctx, state)
        enterRule(_localctx, 144, RULE_filterExpr)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 800
                match(FIELD_NAME)
                state = 801
                match(POINT)
                state = 802
                match(FILTER)
                state = 803
                match(LEFT_FIGURE_BRACE)
                state = 804
                lambdaParams()
                state = 805
                match(ARROW)
                state = 806
                condition()
                state = 807
                match(RIGHT_FIGURE_BRACE)
                state = 811
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == LEFT_SQUARE_BRACE) {
                    run {
                        state = 808
                        match(LEFT_SQUARE_BRACE)
                        state = 809
                        _la = _input.LA(1)
                        if (!(_la == STRING || _la == LONG)) {
                            _errHandler.recoverInline(this)
                        } else {
                            if (_input.LA(1) == Token.EOF) matchedEOF = true
                            _errHandler.reportMatch(this)
                            consume()
                        }
                        state = 810
                        match(RIGHT_SQUARE_BRACE)
                    }
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class LambdaParamsContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun FIELD_NAME(): List<TerminalNode> {
            return getTokens(FIELD_NAME)
        }

        fun FIELD_NAME(i: Int): TerminalNode {
            return getToken(FIELD_NAME, i)
        }

        fun COMMA(): TerminalNode {
            return getToken(COMMA, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_lambdaParams
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterLambdaParams(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitLambdaParams(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitLambdaParams(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun lambdaParams(): LambdaParamsContext {
        val _localctx = LambdaParamsContext(_ctx, state)
        enterRule(_localctx, 146, RULE_lambdaParams)
        try {
            state = 817
            _errHandler.sync(this)
            when (interpreter.adaptivePredict(_input, 67, _ctx)) {
                1 -> {
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 813
                        match(FIELD_NAME)
                    }
                }

                2 -> {
                    enterOuterAlt(_localctx, 2)
                    run {
                        state = 814
                        match(FIELD_NAME)
                        state = 815
                        match(COMMA)
                        state = 816
                        match(FIELD_NAME)
                    }
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class FlowRowAttrContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun maxLinesCount(): MaxLinesCountContext {
            return getRuleContext(MaxLinesCountContext::class.java, 0)
        }

        fun horizontalSpacing(): HorizontalSpacingContext {
            return getRuleContext(HorizontalSpacingContext::class.java, 0)
        }

        fun verticalSpacing(): VerticalSpacingContext {
            return getRuleContext(VerticalSpacingContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_flowRowAttr
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterFlowRowAttr(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitFlowRowAttr(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitFlowRowAttr(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun flowRowAttr(): FlowRowAttrContext {
        val _localctx = FlowRowAttrContext(_ctx, state)
        enterRule(_localctx, 148, RULE_flowRowAttr)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 822
                _errHandler.sync(this)
                when (_input.LA(1)) {
                    MAX_LINES_COUNT -> {
                        state = 819
                        maxLinesCount()
                    }

                    HORIZONTAL_SPACING -> {
                        state = 820
                        horizontalSpacing()
                    }

                    VERTICAL_SPACING -> {
                        state = 821
                        verticalSpacing()
                    }

                    else -> throw NoViableAltException(this)
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class MaxLinesCountContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun MAX_LINES_COUNT(): TerminalNode {
            return getToken(MAX_LINES_COUNT, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun FLONG(): TerminalNode {
            return getToken(FLONG, 0)
        }

        fun attrExpression(): AttrExpressionContext {
            return getRuleContext(AttrExpressionContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_maxLinesCount
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterMaxLinesCount(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitMaxLinesCount(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitMaxLinesCount(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun maxLinesCount(): MaxLinesCountContext {
        val _localctx = MaxLinesCountContext(_ctx, state)
        enterRule(_localctx, 150, RULE_maxLinesCount)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 824
                match(MAX_LINES_COUNT)
                state = 825
                match(LEFT_FIGURE_BRACE)
                state = 828
                _errHandler.sync(this)
                when (_input.LA(1)) {
                    FLONG -> {
                        state = 826
                        match(FLONG)
                    }

                    IF_THEN, FIELD_NAME -> {
                        state = 827
                        attrExpression()
                    }

                    else -> throw NoViableAltException(this)
                }
                state = 830
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class HorizontalSpacingContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun HORIZONTAL_SPACING(): TerminalNode {
            return getToken(HORIZONTAL_SPACING, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun exact(): ExactContext {
            return getRuleContext(ExactContext::class.java, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_horizontalSpacing
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterHorizontalSpacing(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitHorizontalSpacing(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitHorizontalSpacing(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun horizontalSpacing(): HorizontalSpacingContext {
        val _localctx = HorizontalSpacingContext(_ctx, state)
        enterRule(_localctx, 152, RULE_horizontalSpacing)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 832
                match(HORIZONTAL_SPACING)
                state = 833
                match(LEFT_FIGURE_BRACE)
                state = 834
                exact()
                state = 835
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class VerticalSpacingContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun VERTICAL_SPACING(): TerminalNode {
            return getToken(VERTICAL_SPACING, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun exact(): ExactContext {
            return getRuleContext(ExactContext::class.java, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_verticalSpacing
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterVerticalSpacing(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitVerticalSpacing(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitVerticalSpacing(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun verticalSpacing(): VerticalSpacingContext {
        val _localctx = VerticalSpacingContext(_ctx, state)
        enterRule(_localctx, 154, RULE_verticalSpacing)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 837
                match(VERTICAL_SPACING)
                state = 838
                match(LEFT_FIGURE_BRACE)
                state = 839
                exact()
                state = 840
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class TextNodeContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun TEXT_NODE(): TerminalNode {
            return getToken(TEXT_NODE, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun viewAttr(): List<ViewAttrContext> {
            return getRuleContexts(ViewAttrContext::class.java)
        }

        fun viewAttr(i: Int): ViewAttrContext {
            return getRuleContext(ViewAttrContext::class.java, i)
        }

        fun layoutAttr(): List<LayoutAttrContext> {
            return getRuleContexts(LayoutAttrContext::class.java)
        }

        fun layoutAttr(i: Int): LayoutAttrContext {
            return getRuleContext(LayoutAttrContext::class.java, i)
        }

        fun tapAttr(): List<TapAttrContext> {
            return getRuleContexts(TapAttrContext::class.java)
        }

        fun tapAttr(i: Int): TapAttrContext {
            return getRuleContext(TapAttrContext::class.java, i)
        }

        fun textAttr(): List<TextAttrContext> {
            return getRuleContexts(TextAttrContext::class.java)
        }

        fun textAttr(i: Int): TextAttrContext {
            return getRuleContext(TextAttrContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_textNode
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterTextNode(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitTextNode(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitTextNode(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun textNode(): TextNodeContext {
        val _localctx = TextNodeContext(_ctx, state)
        enterRule(_localctx, 156, RULE_textNode)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 842
                match(TEXT_NODE)
                state = 843
                match(LEFT_FIGURE_BRACE)
                state = 850
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (((((_la - 18)) and 0x3f.inv()) == 0 && ((1L shl (_la - 18)) and 1008806316791367679L) != 0L)) {
                    run {
                        state = 848
                        _errHandler.sync(this)
                        when (_input.LA(1)) {
                            TEST_TAG, ALPHA, PADDING, BACKGROUND, IS_ENABLED, IS_VISIBLE -> {
                                state = 844
                                viewAttr()
                            }

                            WIDTH, HEIGHT, WEIGHT, GRAVITY, MARGIN -> {
                                state = 845
                                layoutAttr()
                            }

                            ON_TAP, ON_LONG_TAP, ON_PRESSED_CHANGE -> {
                                state = 846
                                tapAttr()
                            }

                            TEXT, TEXT_CONFIG, ALIGN, OVERFLOW, MAX_LINES, LINE_HEIGHT, LETTER_SPACING -> {
                                state = 847
                                textAttr()
                            }

                            else -> throw NoViableAltException(this)
                        }
                    }
                    state = 852
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 853
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class TextAttrContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun text(): TextContext {
            return getRuleContext(TextContext::class.java, 0)
        }

        fun textConfig(): TextConfigContext {
            return getRuleContext(TextConfigContext::class.java, 0)
        }

        fun align(): AlignContext {
            return getRuleContext(AlignContext::class.java, 0)
        }

        fun overflow(): OverflowContext {
            return getRuleContext(OverflowContext::class.java, 0)
        }

        fun maxLines(): MaxLinesContext {
            return getRuleContext(MaxLinesContext::class.java, 0)
        }

        fun lineHeight(): LineHeightContext {
            return getRuleContext(LineHeightContext::class.java, 0)
        }

        fun letterSpacing(): LetterSpacingContext {
            return getRuleContext(LetterSpacingContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_textAttr
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterTextAttr(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitTextAttr(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitTextAttr(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun textAttr(): TextAttrContext {
        val _localctx = TextAttrContext(_ctx, state)
        enterRule(_localctx, 158, RULE_textAttr)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 862
                _errHandler.sync(this)
                when (_input.LA(1)) {
                    TEXT -> {
                        state = 855
                        text()
                    }

                    TEXT_CONFIG -> {
                        state = 856
                        textConfig()
                    }

                    ALIGN -> {
                        state = 857
                        align()
                    }

                    OVERFLOW -> {
                        state = 858
                        overflow()
                    }

                    MAX_LINES -> {
                        state = 859
                        maxLines()
                    }

                    LINE_HEIGHT -> {
                        state = 860
                        lineHeight()
                    }

                    LETTER_SPACING -> {
                        state = 861
                        letterSpacing()
                    }

                    else -> throw NoViableAltException(this)
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class TextContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun TEXT(): TerminalNode {
            return getToken(TEXT, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun FSTRING(): TerminalNode {
            return getToken(FSTRING, 0)
        }

        fun attrExpression(): AttrExpressionContext {
            return getRuleContext(AttrExpressionContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_text
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterText(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitText(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitText(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun text(): TextContext {
        val _localctx = TextContext(_ctx, state)
        enterRule(_localctx, 160, RULE_text)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 864
                match(TEXT)
                state = 865
                match(LEFT_FIGURE_BRACE)
                state = 868
                _errHandler.sync(this)
                when (_input.LA(1)) {
                    FSTRING -> {
                        state = 866
                        match(FSTRING)
                    }

                    IF_THEN, FIELD_NAME -> {
                        state = 867
                        attrExpression()
                    }

                    else -> throw NoViableAltException(this)
                }
                state = 870
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class TextConfigContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun TEXT_CONFIG(): TerminalNode {
            return getToken(TEXT_CONFIG, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun configAttr(): List<ConfigAttrContext> {
            return getRuleContexts(ConfigAttrContext::class.java)
        }

        fun configAttr(i: Int): ConfigAttrContext {
            return getRuleContext(ConfigAttrContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_textConfig
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterTextConfig(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitTextConfig(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitTextConfig(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun textConfig(): TextConfigContext {
        val _localctx = TextConfigContext(_ctx, state)
        enterRule(_localctx, 162, RULE_textConfig)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 872
                match(TEXT_CONFIG)
                state = 873
                match(LEFT_FIGURE_BRACE)
                state = 877
                _errHandler.sync(this)
                _la = _input.LA(1)
                while ((((_la) and 0x3f.inv()) == 0 && ((1L shl _la) and 2063731785728L) != 0L)) {
                    run {
                        run {
                            state = 874
                            configAttr()
                        }
                    }
                    state = 879
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 880
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class ConfigAttrContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun color(): ColorContext {
            return getRuleContext(ColorContext::class.java, 0)
        }

        fun fontSize(): FontSizeContext {
            return getRuleContext(FontSizeContext::class.java, 0)
        }

        fun fontStyle(): FontStyleContext {
            return getRuleContext(FontStyleContext::class.java, 0)
        }

        val isUnderline: IsUnderlineContext
            get() = getRuleContext(IsUnderlineContext::class.java, 0)
        val isStrikeThrough: IsStrikeThroughContext
            get() = getRuleContext(IsStrikeThroughContext::class.java, 0)

        override fun getRuleIndex(): Int {
            return RULE_configAttr
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterConfigAttr(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitConfigAttr(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitConfigAttr(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun configAttr(): ConfigAttrContext {
        val _localctx = ConfigAttrContext(_ctx, state)
        enterRule(_localctx, 164, RULE_configAttr)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 887
                _errHandler.sync(this)
                when (_input.LA(1)) {
                    COLOR -> {
                        state = 882
                        color()
                    }

                    FONT_SIZE -> {
                        state = 883
                        fontSize()
                    }

                    FONT_STYLE -> {
                        state = 884
                        fontStyle()
                    }

                    IS_UNDERLINE -> {
                        state = 885
                        this.isUnderline
                    }

                    IS_STRIKE_THROUGH -> {
                        state = 886
                        this.isStrikeThrough
                    }

                    else -> throw NoViableAltException(this)
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class FontSizeContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun FONT_SIZE(): TerminalNode {
            return getToken(FONT_SIZE, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun exact(): ExactContext {
            return getRuleContext(ExactContext::class.java, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_fontSize
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterFontSize(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitFontSize(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitFontSize(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun fontSize(): FontSizeContext {
        val _localctx = FontSizeContext(_ctx, state)
        enterRule(_localctx, 166, RULE_fontSize)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 889
                match(FONT_SIZE)
                state = 890
                match(LEFT_FIGURE_BRACE)
                state = 891
                exact()
                state = 892
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class FontStyleContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun FONT_STYLE(): TerminalNode {
            return getToken(FONT_STYLE, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun fontStyleValue(): FontStyleValueContext {
            return getRuleContext(FontStyleValueContext::class.java, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_fontStyle
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterFontStyle(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitFontStyle(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitFontStyle(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun fontStyle(): FontStyleContext {
        val _localctx = FontStyleContext(_ctx, state)
        enterRule(_localctx, 168, RULE_fontStyle)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 894
                match(FONT_STYLE)
                state = 895
                match(LEFT_FIGURE_BRACE)
                state = 896
                fontStyleValue()
                state = 897
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class FontStyleValueContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun REGULAR(): TerminalNode {
            return getToken(REGULAR, 0)
        }

        fun BOLD(): TerminalNode {
            return getToken(BOLD, 0)
        }

        fun EXTRA_BOLD_ITALIC(): TerminalNode {
            return getToken(EXTRA_BOLD_ITALIC, 0)
        }

        fun BOLD_ITALIC(): TerminalNode {
            return getToken(BOLD_ITALIC, 0)
        }

        fun SEMI_BOLD(): TerminalNode {
            return getToken(SEMI_BOLD, 0)
        }

        fun MEDIUM(): TerminalNode {
            return getToken(MEDIUM, 0)
        }

        fun ALI_BOLD(): TerminalNode {
            return getToken(ALI_BOLD, 0)
        }

        fun ALI_REGULAR(): TerminalNode {
            return getToken(ALI_REGULAR, 0)
        }

        fun ALI_LIGHT(): TerminalNode {
            return getToken(ALI_LIGHT, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_fontStyleValue
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterFontStyleValue(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitFontStyleValue(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitFontStyleValue(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun fontStyleValue(): FontStyleValueContext {
        val _localctx = FontStyleValueContext(_ctx, state)
        enterRule(_localctx, 170, RULE_fontStyleValue)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 899
                _la = _input.LA(1)
                if (!(((((_la - 114)) and 0x3f.inv()) == 0 && ((1L shl (_la - 114)) and 511L) != 0L))) {
                    _errHandler.recoverInline(this)
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true
                    _errHandler.reportMatch(this)
                    consume()
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class IsUnderlineContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun IS_UNDERLINE(): TerminalNode {
            return getToken(IS_UNDERLINE, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun FBOOLEAN(): TerminalNode {
            return getToken(FBOOLEAN, 0)
        }

        fun attrExpression(): AttrExpressionContext {
            return getRuleContext(AttrExpressionContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_isUnderline
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterIsUnderline(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitIsUnderline(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitIsUnderline(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @get:Throws(RecognitionException::class)
    val isUnderline: IsUnderlineContext
        get() {
            val _localctx = IsUnderlineContext(_ctx, state)
            enterRule(_localctx, 172, RULE_isUnderline)
            try {
                enterOuterAlt(_localctx, 1)
                run {
                    state = 901
                    match(IS_UNDERLINE)
                    state = 902
                    match(LEFT_FIGURE_BRACE)
                    state = 905
                    _errHandler.sync(this)
                    when (_input.LA(1)) {
                        FBOOLEAN -> {
                            state = 903
                            match(FBOOLEAN)
                        }

                        IF_THEN, FIELD_NAME -> {
                            state = 904
                            attrExpression()
                        }

                        else -> throw NoViableAltException(this)
                    }
                    state = 907
                    match(RIGHT_FIGURE_BRACE)
                }
            } catch (re: RecognitionException) {
                _localctx.exception = re
                _errHandler.reportError(this, re)
                _errHandler.recover(this, re)
            } finally {
                exitRule()
            }
            return _localctx
        }

    class IsStrikeThroughContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun IS_STRIKE_THROUGH(): TerminalNode {
            return getToken(IS_STRIKE_THROUGH, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun FBOOLEAN(): TerminalNode {
            return getToken(FBOOLEAN, 0)
        }

        fun attrExpression(): AttrExpressionContext {
            return getRuleContext(AttrExpressionContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_isStrikeThrough
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterIsStrikeThrough(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitIsStrikeThrough(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitIsStrikeThrough(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @get:Throws(RecognitionException::class)
    val isStrikeThrough: IsStrikeThroughContext
        get() {
            val _localctx = IsStrikeThroughContext(_ctx, state)
            enterRule(_localctx, 174, RULE_isStrikeThrough)
            try {
                enterOuterAlt(_localctx, 1)
                run {
                    state = 909
                    match(IS_STRIKE_THROUGH)
                    state = 910
                    match(LEFT_FIGURE_BRACE)
                    state = 913
                    _errHandler.sync(this)
                    when (_input.LA(1)) {
                        FBOOLEAN -> {
                            state = 911
                            match(FBOOLEAN)
                        }

                        IF_THEN, FIELD_NAME -> {
                            state = 912
                            attrExpression()
                        }

                        else -> throw NoViableAltException(this)
                    }
                    state = 915
                    match(RIGHT_FIGURE_BRACE)
                }
            } catch (re: RecognitionException) {
                _localctx.exception = re
                _errHandler.reportError(this, re)
                _errHandler.recover(this, re)
            } finally {
                exitRule()
            }
            return _localctx
        }

    class AlignContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun ALIGN(): TerminalNode {
            return getToken(ALIGN, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun alignValue(): AlignValueContext {
            return getRuleContext(AlignValueContext::class.java, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_align
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterAlign(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitAlign(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitAlign(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun align(): AlignContext {
        val _localctx = AlignContext(_ctx, state)
        enterRule(_localctx, 176, RULE_align)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 917
                match(ALIGN)
                state = 918
                match(LEFT_FIGURE_BRACE)
                state = 919
                alignValue()
                state = 920
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class AlignValueContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun CENTER(): TerminalNode {
            return getToken(CENTER, 0)
        }

        fun START(): TerminalNode {
            return getToken(START, 0)
        }

        fun END(): TerminalNode {
            return getToken(END, 0)
        }

        fun JUSTIFY(): TerminalNode {
            return getToken(JUSTIFY, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_alignValue
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterAlignValue(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitAlignValue(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitAlignValue(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun alignValue(): AlignValueContext {
        val _localctx = AlignValueContext(_ctx, state)
        enterRule(_localctx, 178, RULE_alignValue)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 922
                _la = _input.LA(1)
                if (!(((((_la - 80)) and 0x3f.inv()) == 0 && ((1L shl (_la - 80)) and 3222274049L) != 0L))) {
                    _errHandler.recoverInline(this)
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true
                    _errHandler.reportMatch(this)
                    consume()
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class OverflowContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun OVERFLOW(): TerminalNode {
            return getToken(OVERFLOW, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun overflowValue(): OverflowValueContext {
            return getRuleContext(OverflowValueContext::class.java, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_overflow
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterOverflow(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitOverflow(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitOverflow(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun overflow(): OverflowContext {
        val _localctx = OverflowContext(_ctx, state)
        enterRule(_localctx, 180, RULE_overflow)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 924
                match(OVERFLOW)
                state = 925
                match(LEFT_FIGURE_BRACE)
                state = 926
                overflowValue()
                state = 927
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class OverflowValueContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun ELLIPSIS(): TerminalNode {
            return getToken(ELLIPSIS, 0)
        }

        fun CLIP(): TerminalNode {
            return getToken(CLIP, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_overflowValue
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterOverflowValue(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitOverflowValue(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitOverflowValue(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun overflowValue(): OverflowValueContext {
        val _localctx = OverflowValueContext(_ctx, state)
        enterRule(_localctx, 182, RULE_overflowValue)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 929
                _la = _input.LA(1)
                if (!(_la == ELLIPSIS || _la == CLIP)) {
                    _errHandler.recoverInline(this)
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true
                    _errHandler.reportMatch(this)
                    consume()
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class MaxLinesContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun MAX_LINES(): TerminalNode {
            return getToken(MAX_LINES, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun FLONG(): TerminalNode {
            return getToken(FLONG, 0)
        }

        fun attrExpression(): AttrExpressionContext {
            return getRuleContext(AttrExpressionContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_maxLines
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterMaxLines(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitMaxLines(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitMaxLines(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun maxLines(): MaxLinesContext {
        val _localctx = MaxLinesContext(_ctx, state)
        enterRule(_localctx, 184, RULE_maxLines)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 931
                match(MAX_LINES)
                state = 932
                match(LEFT_FIGURE_BRACE)
                state = 935
                _errHandler.sync(this)
                when (_input.LA(1)) {
                    FLONG -> {
                        state = 933
                        match(FLONG)
                    }

                    IF_THEN, FIELD_NAME -> {
                        state = 934
                        attrExpression()
                    }

                    else -> throw NoViableAltException(this)
                }
                state = 937
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class LineHeightContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun LINE_HEIGHT(): TerminalNode {
            return getToken(LINE_HEIGHT, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun exact(): ExactContext {
            return getRuleContext(ExactContext::class.java, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_lineHeight
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterLineHeight(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitLineHeight(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitLineHeight(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun lineHeight(): LineHeightContext {
        val _localctx = LineHeightContext(_ctx, state)
        enterRule(_localctx, 186, RULE_lineHeight)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 939
                match(LINE_HEIGHT)
                state = 940
                match(LEFT_FIGURE_BRACE)
                state = 941
                exact()
                state = 942
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class LetterSpacingContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun LETTER_SPACING(): TerminalNode {
            return getToken(LETTER_SPACING, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun exact(): ExactContext {
            return getRuleContext(ExactContext::class.java, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_letterSpacing
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterLetterSpacing(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitLetterSpacing(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitLetterSpacing(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun letterSpacing(): LetterSpacingContext {
        val _localctx = LetterSpacingContext(_ctx, state)
        enterRule(_localctx, 188, RULE_letterSpacing)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 944
                match(LETTER_SPACING)
                state = 945
                match(LEFT_FIGURE_BRACE)
                state = 946
                exact()
                state = 947
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class ImageNodeContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun IMAGE_NODE(): TerminalNode {
            return getToken(IMAGE_NODE, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun imageAttr(): List<ImageAttrContext> {
            return getRuleContexts(ImageAttrContext::class.java)
        }

        fun imageAttr(i: Int): ImageAttrContext {
            return getRuleContext(ImageAttrContext::class.java, i)
        }

        fun layoutAttr(): List<LayoutAttrContext> {
            return getRuleContexts(LayoutAttrContext::class.java)
        }

        fun layoutAttr(i: Int): LayoutAttrContext {
            return getRuleContext(LayoutAttrContext::class.java, i)
        }

        fun tapAttr(): List<TapAttrContext> {
            return getRuleContexts(TapAttrContext::class.java)
        }

        fun tapAttr(i: Int): TapAttrContext {
            return getRuleContext(TapAttrContext::class.java, i)
        }

        fun viewAttr(): List<ViewAttrContext> {
            return getRuleContexts(ViewAttrContext::class.java)
        }

        fun viewAttr(i: Int): ViewAttrContext {
            return getRuleContext(ViewAttrContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_imageNode
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterImageNode(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitImageNode(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitImageNode(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun imageNode(): ImageNodeContext {
        val _localctx = ImageNodeContext(_ctx, state)
        enterRule(_localctx, 190, RULE_imageNode)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 949
                match(IMAGE_NODE)
                state = 950
                match(LEFT_FIGURE_BRACE)
                state = 957
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (((((_la - 18)) and 0x3f.inv()) == 0 && ((1L shl (_la - 18)) and 1008808481194510335L) != 0L)) {
                    run {
                        state = 955
                        _errHandler.sync(this)
                        when (_input.LA(1)) {
                            SOURCE, PLACEHOLDER, PLACEHOLDER_TINT, TINT, RESIZE_MODE, ANIMATE_CHANGES -> {
                                state = 951
                                imageAttr()
                            }

                            WIDTH, HEIGHT, WEIGHT, GRAVITY, MARGIN -> {
                                state = 952
                                layoutAttr()
                            }

                            ON_TAP, ON_LONG_TAP, ON_PRESSED_CHANGE -> {
                                state = 953
                                tapAttr()
                            }

                            TEST_TAG, ALPHA, PADDING, BACKGROUND, IS_ENABLED, IS_VISIBLE -> {
                                state = 954
                                viewAttr()
                            }

                            else -> throw NoViableAltException(this)
                        }
                    }
                    state = 959
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 960
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class ImageAttrContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun source(): SourceContext {
            return getRuleContext(SourceContext::class.java, 0)
        }

        fun placeholder(): PlaceholderContext {
            return getRuleContext(PlaceholderContext::class.java, 0)
        }

        fun placeholderTint(): PlaceholderTintContext {
            return getRuleContext(PlaceholderTintContext::class.java, 0)
        }

        fun tint(): TintContext {
            return getRuleContext(TintContext::class.java, 0)
        }

        fun resizeMode(): ResizeModeContext {
            return getRuleContext(ResizeModeContext::class.java, 0)
        }

        fun animateChanges(): AnimateChangesContext {
            return getRuleContext(AnimateChangesContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_imageAttr
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterImageAttr(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitImageAttr(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitImageAttr(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun imageAttr(): ImageAttrContext {
        val _localctx = ImageAttrContext(_ctx, state)
        enterRule(_localctx, 192, RULE_imageAttr)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 968
                _errHandler.sync(this)
                when (_input.LA(1)) {
                    SOURCE -> {
                        state = 962
                        source()
                    }

                    PLACEHOLDER -> {
                        state = 963
                        placeholder()
                    }

                    PLACEHOLDER_TINT -> {
                        state = 964
                        placeholderTint()
                    }

                    TINT -> {
                        state = 965
                        tint()
                    }

                    RESIZE_MODE -> {
                        state = 966
                        resizeMode()
                    }

                    ANIMATE_CHANGES -> {
                        state = 967
                        animateChanges()
                    }

                    else -> throw NoViableAltException(this)
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class SourceContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun SOURCE(): TerminalNode {
            return getToken(SOURCE, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun FSTRING(): TerminalNode {
            return getToken(FSTRING, 0)
        }

        fun attrExpression(): AttrExpressionContext {
            return getRuleContext(AttrExpressionContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_source
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterSource(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitSource(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitSource(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun source(): SourceContext {
        val _localctx = SourceContext(_ctx, state)
        enterRule(_localctx, 194, RULE_source)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 970
                match(SOURCE)
                state = 971
                match(LEFT_FIGURE_BRACE)
                state = 974
                _errHandler.sync(this)
                when (_input.LA(1)) {
                    FSTRING -> {
                        state = 972
                        match(FSTRING)
                    }

                    IF_THEN, FIELD_NAME -> {
                        state = 973
                        attrExpression()
                    }

                    else -> throw NoViableAltException(this)
                }
                state = 976
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class PlaceholderContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun PLACEHOLDER(): TerminalNode {
            return getToken(PLACEHOLDER, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun colorHEX(): ColorHEXContext {
            return getRuleContext(ColorHEXContext::class.java, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_placeholder
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterPlaceholder(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitPlaceholder(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitPlaceholder(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun placeholder(): PlaceholderContext {
        val _localctx = PlaceholderContext(_ctx, state)
        enterRule(_localctx, 196, RULE_placeholder)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 978
                match(PLACEHOLDER)
                state = 979
                match(LEFT_FIGURE_BRACE)
                state = 980
                colorHEX()
                state = 981
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class PlaceholderTintContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun PLACEHOLDER_TINT(): TerminalNode {
            return getToken(PLACEHOLDER_TINT, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun colorHEX(): ColorHEXContext {
            return getRuleContext(ColorHEXContext::class.java, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_placeholderTint
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterPlaceholderTint(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitPlaceholderTint(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitPlaceholderTint(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun placeholderTint(): PlaceholderTintContext {
        val _localctx = PlaceholderTintContext(_ctx, state)
        enterRule(_localctx, 198, RULE_placeholderTint)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 983
                match(PLACEHOLDER_TINT)
                state = 984
                match(LEFT_FIGURE_BRACE)
                state = 985
                colorHEX()
                state = 986
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class TintContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun TINT(): TerminalNode {
            return getToken(TINT, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun colorHEX(): ColorHEXContext {
            return getRuleContext(ColorHEXContext::class.java, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_tint
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterTint(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitTint(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitTint(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun tint(): TintContext {
        val _localctx = TintContext(_ctx, state)
        enterRule(_localctx, 200, RULE_tint)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 988
                match(TINT)
                state = 989
                match(LEFT_FIGURE_BRACE)
                state = 990
                colorHEX()
                state = 991
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class ResizeModeContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun RESIZE_MODE(): TerminalNode {
            return getToken(RESIZE_MODE, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun resizeModeValue(): ResizeModeValueContext {
            return getRuleContext(ResizeModeValueContext::class.java, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_resizeMode
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterResizeMode(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitResizeMode(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitResizeMode(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun resizeMode(): ResizeModeContext {
        val _localctx = ResizeModeContext(_ctx, state)
        enterRule(_localctx, 202, RULE_resizeMode)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 993
                match(RESIZE_MODE)
                state = 994
                match(LEFT_FIGURE_BRACE)
                state = 995
                resizeModeValue()
                state = 996
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class ResizeModeValueContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun ASPECT_FIT(): TerminalNode {
            return getToken(ASPECT_FIT, 0)
        }

        fun SCALE_TO_FILL(): TerminalNode {
            return getToken(SCALE_TO_FILL, 0)
        }

        fun ASPECT_FILL(): TerminalNode {
            return getToken(ASPECT_FILL, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_resizeModeValue
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterResizeModeValue(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitResizeModeValue(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitResizeModeValue(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun resizeModeValue(): ResizeModeValueContext {
        val _localctx = ResizeModeValueContext(_ctx, state)
        enterRule(_localctx, 204, RULE_resizeModeValue)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 998
                _la = _input.LA(1)
                if (!(((((_la - 83)) and 0x3f.inv()) == 0 && ((1L shl (_la - 83)) and 7L) != 0L))) {
                    _errHandler.recoverInline(this)
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true
                    _errHandler.reportMatch(this)
                    consume()
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class AnimateChangesContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun ANIMATE_CHANGES(): TerminalNode {
            return getToken(ANIMATE_CHANGES, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun animateChangesValue(): AnimateChangesValueContext {
            return getRuleContext(AnimateChangesValueContext::class.java, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_animateChanges
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterAnimateChanges(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitAnimateChanges(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitAnimateChanges(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun animateChanges(): AnimateChangesContext {
        val _localctx = AnimateChangesContext(_ctx, state)
        enterRule(_localctx, 206, RULE_animateChanges)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 1000
                match(ANIMATE_CHANGES)
                state = 1001
                match(LEFT_FIGURE_BRACE)
                state = 1002
                animateChangesValue()
                state = 1003
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class AnimateChangesValueContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun NONE(): TerminalNode {
            return getToken(NONE, 0)
        }

        fun CROSS_FADE(): TerminalNode {
            return getToken(CROSS_FADE, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_animateChangesValue
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterAnimateChangesValue(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitAnimateChangesValue(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitAnimateChangesValue(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun animateChangesValue(): AnimateChangesValueContext {
        val _localctx = AnimateChangesValueContext(_ctx, state)
        enterRule(_localctx, 208, RULE_animateChangesValue)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 1005
                _la = _input.LA(1)
                if (!(_la == NONE || _la == CROSS_FADE)) {
                    _errHandler.recoverInline(this)
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true
                    _errHandler.reportMatch(this)
                    consume()
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class TextFieldNodeContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun TEXT_FIELD_NODE(): TerminalNode {
            return getToken(TEXT_FIELD_NODE, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun textFieldAttr(): List<TextFieldAttrContext> {
            return getRuleContexts(TextFieldAttrContext::class.java)
        }

        fun textFieldAttr(i: Int): TextFieldAttrContext {
            return getRuleContext(TextFieldAttrContext::class.java, i)
        }

        fun layoutAttr(): List<LayoutAttrContext> {
            return getRuleContexts(LayoutAttrContext::class.java)
        }

        fun layoutAttr(i: Int): LayoutAttrContext {
            return getRuleContext(LayoutAttrContext::class.java, i)
        }

        fun tapAttr(): List<TapAttrContext> {
            return getRuleContexts(TapAttrContext::class.java)
        }

        fun tapAttr(i: Int): TapAttrContext {
            return getRuleContext(TapAttrContext::class.java, i)
        }

        fun viewAttr(): List<ViewAttrContext> {
            return getRuleContexts(ViewAttrContext::class.java)
        }

        fun viewAttr(i: Int): ViewAttrContext {
            return getRuleContext(ViewAttrContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_textFieldNode
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterTextFieldNode(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitTextFieldNode(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitTextFieldNode(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun textFieldNode(): TextFieldNodeContext {
        val _localctx = TextFieldNodeContext(_ctx, state)
        enterRule(_localctx, 210, RULE_textFieldNode)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 1007
                match(TEXT_FIELD_NODE)
                state = 1008
                match(LEFT_FIGURE_BRACE)
                state = 1015
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (((((_la - 18)) and 0x3f.inv()) == 0 && ((1L shl (_la - 18)) and 1008806334180820991L) != 0L)) {
                    run {
                        state = 1013
                        _errHandler.sync(this)
                        when (_input.LA(1)) {
                            TEXT, CONFIG, LINE_HEIGHT, LETTER_SPACING, KEYBOARD_OPTIONS, IS_MULTILINE -> {
                                state = 1009
                                textFieldAttr()
                            }

                            WIDTH, HEIGHT, WEIGHT, GRAVITY, MARGIN -> {
                                state = 1010
                                layoutAttr()
                            }

                            ON_TAP, ON_LONG_TAP, ON_PRESSED_CHANGE -> {
                                state = 1011
                                tapAttr()
                            }

                            TEST_TAG, ALPHA, PADDING, BACKGROUND, IS_ENABLED, IS_VISIBLE -> {
                                state = 1012
                                viewAttr()
                            }

                            else -> throw NoViableAltException(this)
                        }
                    }
                    state = 1017
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 1018
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class TextFieldAttrContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun text(): TextContext {
            return getRuleContext(TextContext::class.java, 0)
        }

        fun textFieldConfig(): TextFieldConfigContext {
            return getRuleContext(TextFieldConfigContext::class.java, 0)
        }

        fun lineHeight(): LineHeightContext {
            return getRuleContext(LineHeightContext::class.java, 0)
        }

        fun letterSpacing(): LetterSpacingContext {
            return getRuleContext(LetterSpacingContext::class.java, 0)
        }

        val isMultiline: IsMultilineContext
            get() = getRuleContext(IsMultilineContext::class.java, 0)

        fun keyboardOptions(): KeyboardOptionsContext {
            return getRuleContext(KeyboardOptionsContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_textFieldAttr
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterTextFieldAttr(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitTextFieldAttr(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitTextFieldAttr(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun textFieldAttr(): TextFieldAttrContext {
        val _localctx = TextFieldAttrContext(_ctx, state)
        enterRule(_localctx, 212, RULE_textFieldAttr)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 1026
                _errHandler.sync(this)
                when (_input.LA(1)) {
                    TEXT -> {
                        state = 1020
                        text()
                    }

                    CONFIG -> {
                        state = 1021
                        textFieldConfig()
                    }

                    LINE_HEIGHT -> {
                        state = 1022
                        lineHeight()
                    }

                    LETTER_SPACING -> {
                        state = 1023
                        letterSpacing()
                    }

                    IS_MULTILINE -> {
                        state = 1024
                        this.isMultiline
                    }

                    KEYBOARD_OPTIONS -> {
                        state = 1025
                        keyboardOptions()
                    }

                    else -> throw NoViableAltException(this)
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class TextFieldConfigContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun CONFIG(): TerminalNode {
            return getToken(CONFIG, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun configAttr(): List<ConfigAttrContext> {
            return getRuleContexts(ConfigAttrContext::class.java)
        }

        fun configAttr(i: Int): ConfigAttrContext {
            return getRuleContext(ConfigAttrContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_textFieldConfig
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterTextFieldConfig(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitTextFieldConfig(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitTextFieldConfig(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun textFieldConfig(): TextFieldConfigContext {
        val _localctx = TextFieldConfigContext(_ctx, state)
        enterRule(_localctx, 214, RULE_textFieldConfig)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 1028
                match(CONFIG)
                state = 1029
                match(LEFT_FIGURE_BRACE)
                state = 1033
                _errHandler.sync(this)
                _la = _input.LA(1)
                while ((((_la) and 0x3f.inv()) == 0 && ((1L shl _la) and 2063731785728L) != 0L)) {
                    run {
                        run {
                            state = 1030
                            configAttr()
                        }
                    }
                    state = 1035
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 1036
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class KeyboardOptionsContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun KEYBOARD_OPTIONS(): TerminalNode {
            return getToken(KEYBOARD_OPTIONS, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun keyboardOptionsValue(): List<KeyboardOptionsValueContext> {
            return getRuleContexts(KeyboardOptionsValueContext::class.java)
        }

        fun keyboardOptionsValue(i: Int): KeyboardOptionsValueContext {
            return getRuleContext(KeyboardOptionsValueContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_keyboardOptions
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterKeyboardOptions(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitKeyboardOptions(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitKeyboardOptions(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun keyboardOptions(): KeyboardOptionsContext {
        val _localctx = KeyboardOptionsContext(_ctx, state)
        enterRule(_localctx, 216, RULE_keyboardOptions)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 1038
                match(KEYBOARD_OPTIONS)
                state = 1039
                match(LEFT_FIGURE_BRACE)
                state = 1043
                _errHandler.sync(this)
                _la = _input.LA(1)
                while ((((_la) and 0x3f.inv()) == 0 && ((1L shl _la) and 4362862139015168L) != 0L)) {
                    run {
                        run {
                            state = 1040
                            keyboardOptionsValue()
                        }
                    }
                    state = 1045
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 1046
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class KeyboardOptionsValueContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun capitalization(): CapitalizationContext {
            return getRuleContext(CapitalizationContext::class.java, 0)
        }

        fun autoCorrect(): AutoCorrectContext {
            return getRuleContext(AutoCorrectContext::class.java, 0)
        }

        fun keyboardType(): KeyboardTypeContext {
            return getRuleContext(KeyboardTypeContext::class.java, 0)
        }

        fun imeAction(): ImeActionContext {
            return getRuleContext(ImeActionContext::class.java, 0)
        }

        fun inputAccessoryAction(): InputAccessoryActionContext {
            return getRuleContext(InputAccessoryActionContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_keyboardOptionsValue
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterKeyboardOptionsValue(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitKeyboardOptionsValue(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitKeyboardOptionsValue(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun keyboardOptionsValue(): KeyboardOptionsValueContext {
        val _localctx = KeyboardOptionsValueContext(_ctx, state)
        enterRule(_localctx, 218, RULE_keyboardOptionsValue)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 1053
                _errHandler.sync(this)
                when (_input.LA(1)) {
                    CAPITALIZATION -> {
                        state = 1048
                        capitalization()
                    }

                    AUTO_CORRECT -> {
                        state = 1049
                        autoCorrect()
                    }

                    KEYBOARD_TYPE -> {
                        state = 1050
                        keyboardType()
                    }

                    IME_ACTION -> {
                        state = 1051
                        imeAction()
                    }

                    INPUT_ACCESSORY_ACTION -> {
                        state = 1052
                        inputAccessoryAction()
                    }

                    else -> throw NoViableAltException(this)
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class CapitalizationContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun CAPITALIZATION(): TerminalNode {
            return getToken(CAPITALIZATION, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun capitalizationValue(): CapitalizationValueContext {
            return getRuleContext(CapitalizationValueContext::class.java, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_capitalization
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterCapitalization(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitCapitalization(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitCapitalization(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun capitalization(): CapitalizationContext {
        val _localctx = CapitalizationContext(_ctx, state)
        enterRule(_localctx, 220, RULE_capitalization)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 1055
                match(CAPITALIZATION)
                state = 1056
                match(LEFT_FIGURE_BRACE)
                state = 1057
                capitalizationValue()
                state = 1058
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class CapitalizationValueContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun NONE(): TerminalNode {
            return getToken(NONE, 0)
        }

        fun CHARACTERS(): TerminalNode {
            return getToken(CHARACTERS, 0)
        }

        fun WORDS(): TerminalNode {
            return getToken(WORDS, 0)
        }

        fun SENTENCES(): TerminalNode {
            return getToken(SENTENCES, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_capitalizationValue
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterCapitalizationValue(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitCapitalizationValue(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitCapitalizationValue(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun capitalizationValue(): CapitalizationValueContext {
        val _localctx = CapitalizationValueContext(_ctx, state)
        enterRule(_localctx, 222, RULE_capitalizationValue)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 1060
                _la = _input.LA(1)
                if (!(((((_la - 86)) and 0x3f.inv()) == 0 && ((1L shl (_la - 86)) and 962072674305L) != 0L))) {
                    _errHandler.recoverInline(this)
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true
                    _errHandler.reportMatch(this)
                    consume()
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class AutoCorrectContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun AUTO_CORRECT(): TerminalNode {
            return getToken(AUTO_CORRECT, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun FBOOLEAN(): TerminalNode {
            return getToken(FBOOLEAN, 0)
        }

        fun attrExpression(): AttrExpressionContext {
            return getRuleContext(AttrExpressionContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_autoCorrect
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterAutoCorrect(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitAutoCorrect(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitAutoCorrect(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun autoCorrect(): AutoCorrectContext {
        val _localctx = AutoCorrectContext(_ctx, state)
        enterRule(_localctx, 224, RULE_autoCorrect)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 1062
                match(AUTO_CORRECT)
                state = 1063
                match(LEFT_FIGURE_BRACE)
                state = 1066
                _errHandler.sync(this)
                when (_input.LA(1)) {
                    FBOOLEAN -> {
                        state = 1064
                        match(FBOOLEAN)
                    }

                    IF_THEN, FIELD_NAME -> {
                        state = 1065
                        attrExpression()
                    }

                    else -> throw NoViableAltException(this)
                }
                state = 1068
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class KeyboardTypeContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun KEYBOARD_TYPE(): TerminalNode {
            return getToken(KEYBOARD_TYPE, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun keyboardTypeValue(): KeyboardTypeValueContext {
            return getRuleContext(KeyboardTypeValueContext::class.java, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_keyboardType
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterKeyboardType(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitKeyboardType(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitKeyboardType(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun keyboardType(): KeyboardTypeContext {
        val _localctx = KeyboardTypeContext(_ctx, state)
        enterRule(_localctx, 226, RULE_keyboardType)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 1070
                match(KEYBOARD_TYPE)
                state = 1071
                match(LEFT_FIGURE_BRACE)
                state = 1072
                keyboardTypeValue()
                state = 1073
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class KeyboardTypeValueContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun TEXT(): TerminalNode {
            return getToken(TEXT, 0)
        }

        fun ASCII(): TerminalNode {
            return getToken(ASCII, 0)
        }

        fun NUMBER(): TerminalNode {
            return getToken(NUMBER, 0)
        }

        fun PHONE(): TerminalNode {
            return getToken(PHONE, 0)
        }

        fun URI(): TerminalNode {
            return getToken(URI, 0)
        }

        fun EMAIL(): TerminalNode {
            return getToken(EMAIL, 0)
        }

        fun PASSWORD(): TerminalNode {
            return getToken(PASSWORD, 0)
        }

        fun NUMBER_PASSWORD(): TerminalNode {
            return getToken(NUMBER_PASSWORD, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_keyboardTypeValue
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterKeyboardTypeValue(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitKeyboardTypeValue(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitKeyboardTypeValue(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun keyboardTypeValue(): KeyboardTypeValueContext {
        val _localctx = KeyboardTypeValueContext(_ctx, state)
        enterRule(_localctx, 228, RULE_keyboardTypeValue)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 1075
                _la = _input.LA(1)
                if (!(_la == TEXT || ((((_la - 126)) and 0x3f.inv()) == 0 && ((1L shl (_la - 126)) and 127L) != 0L))) {
                    _errHandler.recoverInline(this)
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true
                    _errHandler.reportMatch(this)
                    consume()
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class ImeActionContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun IME_ACTION(): TerminalNode {
            return getToken(IME_ACTION, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun imeActionValue(): ImeActionValueContext {
            return getRuleContext(ImeActionValueContext::class.java, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_imeAction
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterImeAction(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitImeAction(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitImeAction(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun imeAction(): ImeActionContext {
        val _localctx = ImeActionContext(_ctx, state)
        enterRule(_localctx, 230, RULE_imeAction)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 1077
                match(IME_ACTION)
                state = 1078
                match(LEFT_FIGURE_BRACE)
                state = 1079
                imeActionValue()
                state = 1080
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class ImeActionValueContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun DEFAULT(): TerminalNode {
            return getToken(DEFAULT, 0)
        }

        fun NONE(): TerminalNode {
            return getToken(NONE, 0)
        }

        fun GO(): TerminalNode {
            return getToken(GO, 0)
        }

        fun SEARCH(): TerminalNode {
            return getToken(SEARCH, 0)
        }

        fun SEND(): TerminalNode {
            return getToken(SEND, 0)
        }

        fun PREVIOUS(): TerminalNode {
            return getToken(PREVIOUS, 0)
        }

        fun NEXT(): TerminalNode {
            return getToken(NEXT, 0)
        }

        fun DONE(): TerminalNode {
            return getToken(DONE, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_imeActionValue
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterImeActionValue(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitImeActionValue(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitImeActionValue(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun imeActionValue(): ImeActionValueContext {
        val _localctx = ImeActionValueContext(_ctx, state)
        enterRule(_localctx, 232, RULE_imeActionValue)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 1082
                _la = _input.LA(1)
                if (!(((((_la - 86)) and 0x3f.inv()) == 0 && ((1L shl (_la - 86)) and 17873661021126657L) != 0L))) {
                    _errHandler.recoverInline(this)
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true
                    _errHandler.reportMatch(this)
                    consume()
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class InputAccessoryActionContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun INPUT_ACCESSORY_ACTION(): TerminalNode {
            return getToken(INPUT_ACCESSORY_ACTION, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun imeActionValue(): ImeActionValueContext {
            return getRuleContext(ImeActionValueContext::class.java, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_inputAccessoryAction
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterInputAccessoryAction(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitInputAccessoryAction(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitInputAccessoryAction(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun inputAccessoryAction(): InputAccessoryActionContext {
        val _localctx = InputAccessoryActionContext(_ctx, state)
        enterRule(_localctx, 234, RULE_inputAccessoryAction)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 1084
                match(INPUT_ACCESSORY_ACTION)
                state = 1085
                match(LEFT_FIGURE_BRACE)
                state = 1086
                imeActionValue()
                state = 1087
                match(RIGHT_FIGURE_BRACE)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class IsMultilineContext(parent: ParserRuleContext?, invokingState: Int) :
        ParserRuleContext(parent, invokingState) {
        fun IS_MULTILINE(): TerminalNode {
            return getToken(IS_MULTILINE, 0)
        }

        fun LEFT_FIGURE_BRACE(): TerminalNode {
            return getToken(LEFT_FIGURE_BRACE, 0)
        }

        fun RIGHT_FIGURE_BRACE(): TerminalNode {
            return getToken(RIGHT_FIGURE_BRACE, 0)
        }

        fun FBOOLEAN(): TerminalNode {
            return getToken(FBOOLEAN, 0)
        }

        fun attrExpression(): AttrExpressionContext {
            return getRuleContext(AttrExpressionContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_isMultiline
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.enterIsMultiline(
                this
            )
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is DSLGrammarListener) listener.exitIsMultiline(
                this
            )
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is DSLGrammarVisitor<*>) (visitor as DSLGrammarVisitor<out T>).visitIsMultiline(
                this
            )
            else visitor.visitChildren(this)
        }
    }

    @get:Throws(RecognitionException::class)
    val isMultiline: IsMultilineContext
        get() {
            val _localctx = IsMultilineContext(_ctx, state)
            enterRule(_localctx, 236, RULE_isMultiline)
            try {
                enterOuterAlt(_localctx, 1)
                run {
                    state = 1089
                    match(IS_MULTILINE)
                    state = 1090
                    match(LEFT_FIGURE_BRACE)
                    state = 1093
                    _errHandler.sync(this)
                    when (_input.LA(1)) {
                        FBOOLEAN -> {
                            state = 1091
                            match(FBOOLEAN)
                        }

                        IF_THEN, FIELD_NAME -> {
                            state = 1092
                            attrExpression()
                        }

                        else -> throw NoViableAltException(this)
                    }
                    state = 1095
                    match(RIGHT_FIGURE_BRACE)
                }
            } catch (re: RecognitionException) {
                _localctx.exception = re
                _errHandler.reportError(this, re)
                _errHandler.recover(this, re)
            } finally {
                exitRule()
            }
            return _localctx
        }

    init {
        _interp = ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache)
    }

    companion object {
        init {
            RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION)
        }

        protected val _decisionToDFA: Array<DFA?>
        protected val _sharedContextCache: PredictionContextCache = PredictionContextCache()
        const val BOX: Int = 1
        const val COLUMN: Int = 2
        const val FLOW_ROW: Int = 3
        const val LAZY_COLUMN: Int = 4
        const val LAZY_ROW: Int = 5
        const val ROW: Int = 6
        const val TEXT_NODE: Int = 7
        const val TEXT_FIELD_NODE: Int = 8
        const val IMAGE_NODE: Int = 9
        const val LEFT_FIGURE_BRACE: Int = 10
        const val RIGHT_FIGURE_BRACE: Int = 11
        const val LEFT_BRACE: Int = 12
        const val RIGHT_BRACE: Int = 13
        const val LEFT_SQUARE_BRACE: Int = 14
        const val RIGHT_SQUARE_BRACE: Int = 15
        const val LEFT_ANGLE_BRACE: Int = 16
        const val RIGHT_ANGLE_BRACE: Int = 17
        const val WIDTH: Int = 18
        const val HEIGHT: Int = 19
        const val WEIGHT: Int = 20
        const val GRAVITY: Int = 21
        const val MARGIN: Int = 22
        const val TEST_TAG: Int = 23
        const val ALPHA: Int = 24
        const val PADDING: Int = 25
        const val BACKGROUND: Int = 26
        const val IS_ENABLED: Int = 27
        const val IS_VISIBLE: Int = 28
        const val BORDER: Int = 29
        const val CORNERS_RADIUS: Int = 30
        const val COLOR: Int = 31
        const val DASH_SIZE: Int = 32
        const val DASH_GAP: Int = 33
        const val TEXT: Int = 34
        const val CONFIG: Int = 35
        const val TEXT_CONFIG: Int = 36
        const val FONT_SIZE: Int = 37
        const val FONT_STYLE: Int = 38
        const val IS_UNDERLINE: Int = 39
        const val IS_STRIKE_THROUGH: Int = 40
        const val ALIGN: Int = 41
        const val OVERFLOW: Int = 42
        const val MAX_LINES: Int = 43
        const val LINE_HEIGHT: Int = 44
        const val LETTER_SPACING: Int = 45
        const val KEYBOARD_OPTIONS: Int = 46
        const val CAPITALIZATION: Int = 47
        const val AUTO_CORRECT: Int = 48
        const val KEYBOARD_TYPE: Int = 49
        const val IME_ACTION: Int = 50
        const val INPUT_ACCESSORY_ACTION: Int = 51
        const val IS_MULTILINE: Int = 52
        const val SOURCE: Int = 53
        const val PLACEHOLDER: Int = 54
        const val PLACEHOLDER_TINT: Int = 55
        const val TINT: Int = 56
        const val RESIZE_MODE: Int = 57
        const val ANIMATE_CHANGES: Int = 58
        const val MAX_LINES_COUNT: Int = 59
        const val HORIZONTAL_SPACING: Int = 60
        const val VERTICAL_SPACING: Int = 61
        const val VAL: Int = 62
        const val TO: Int = 63
        const val MAP: Int = 64
        const val IF_THEN: Int = 65
        const val FILTER: Int = 66
        const val ARRAY: Int = 67
        const val DICTIONARY: Int = 68
        const val STRING_TYPE: Int = 69
        const val BOOLEAN_TYPE: Int = 70
        const val DOUBLE_TYPE: Int = 71
        const val LONG_TYPE: Int = 72
        const val ITEM: Int = 73
        const val ITEMS: Int = 74
        const val ON_TAP: Int = 75
        const val ON_LONG_TAP: Int = 76
        const val ON_PRESSED_CHANGE: Int = 77
        const val FILL: Int = 78
        const val WRAP: Int = 79
        const val JUSTIFY: Int = 80
        const val ELLIPSIS: Int = 81
        const val CLIP: Int = 82
        const val ASPECT_FIT: Int = 83
        const val SCALE_TO_FILL: Int = 84
        const val ASPECT_FILL: Int = 85
        const val NONE: Int = 86
        const val CROSS_FADE: Int = 87
        const val POINT: Int = 88
        const val COMMA: Int = 89
        const val DOUBLE_QUOTES: Int = 90
        const val LATTICE: Int = 91
        const val NP: Int = 92
        const val AP: Int = 93
        const val PLUS: Int = 94
        const val MINUS: Int = 95
        const val ASSIGN: Int = 96
        const val EQUAL: Int = 97
        const val NOT_EQUAL: Int = 98
        const val ARROW: Int = 99
        const val CENTER: Int = 100
        const val LEFT: Int = 101
        const val RIGHT: Int = 102
        const val TOP: Int = 103
        const val BOTTOM: Int = 104
        const val LEFT_TOP: Int = 105
        const val RIGHT_TOP: Int = 106
        const val LEFT_BOTTOM: Int = 107
        const val RIGHT_BOTTOM: Int = 108
        const val ALL: Int = 109
        const val START: Int = 110
        const val END: Int = 111
        const val HORIZONTAL: Int = 112
        const val VERTICAL: Int = 113
        const val REGULAR: Int = 114
        const val BOLD: Int = 115
        const val EXTRA_BOLD_ITALIC: Int = 116
        const val BOLD_ITALIC: Int = 117
        const val SEMI_BOLD: Int = 118
        const val MEDIUM: Int = 119
        const val ALI_BOLD: Int = 120
        const val ALI_REGULAR: Int = 121
        const val ALI_LIGHT: Int = 122
        const val CHARACTERS: Int = 123
        const val WORDS: Int = 124
        const val SENTENCES: Int = 125
        const val ASCII: Int = 126
        const val NUMBER: Int = 127
        const val PHONE: Int = 128
        const val URI: Int = 129
        const val EMAIL: Int = 130
        const val PASSWORD: Int = 131
        const val NUMBER_PASSWORD: Int = 132
        const val DEFAULT: Int = 133
        const val GO: Int = 134
        const val SEARCH: Int = 135
        const val SEND: Int = 136
        const val PREVIOUS: Int = 137
        const val NEXT: Int = 138
        const val DONE: Int = 139
        const val HEX: Int = 140
        const val STRING: Int = 141
        const val FSTRING: Int = 142
        const val BOOLEAN: Int = 143
        const val FBOOLEAN: Int = 144
        const val DOUBLE: Int = 145
        const val FDOUBLE: Int = 146
        const val LONG: Int = 147
        const val FLONG: Int = 148
        const val FIELD_NAME: Int = 149
        const val C: Int = 150
        const val WS: Int = 151
        const val RULE_start: Int = 0
        const val RULE_fields: Int = 1
        const val RULE_typeValue: Int = 2
        const val RULE_fStringArray: Int = 3
        const val RULE_fBooleanArray: Int = 4
        const val RULE_fDoubleArray: Int = 5
        const val RULE_fLongArray: Int = 6
        const val RULE_fstringArrValue: Int = 7
        const val RULE_fbooleanArrValue: Int = 8
        const val RULE_fdoubleArrValue: Int = 9
        const val RULE_flongArrValue: Int = 10
        const val RULE_fStringDictionary: Int = 11
        const val RULE_fDoubleDictionary: Int = 12
        const val RULE_fLongDictionary: Int = 13
        const val RULE_fBooleanDictionary: Int = 14
        const val RULE_fstringDictValue: Int = 15
        const val RULE_fdoubleDictValue: Int = 16
        const val RULE_flongDictValue: Int = 17
        const val RULE_fbooleanDictValue: Int = 18
        const val RULE_layoutNode: Int = 19
        const val RULE_node: Int = 20
        const val RULE_box: Int = 21
        const val RULE_column: Int = 22
        const val RULE_row: Int = 23
        const val RULE_flowRow: Int = 24
        const val RULE_lazyColumn: Int = 25
        const val RULE_lazyRow: Int = 26
        const val RULE_item: Int = 27
        const val RULE_items: Int = 28
        const val RULE_attrExpression: Int = 29
        const val RULE_ifExpr: Int = 30
        const val RULE_condition: Int = 31
        const val RULE_consts: Int = 32
        const val RULE_fieldExpr: Int = 33
        const val RULE_ifValues: Int = 34
        const val RULE_layoutAttr: Int = 35
        const val RULE_width: Int = 36
        const val RULE_height: Int = 37
        const val RULE_weight: Int = 38
        const val RULE_gravity: Int = 39
        const val RULE_gravityExpression: Int = 40
        const val RULE_gravityValue: Int = 41
        const val RULE_margin: Int = 42
        const val RULE_insets: Int = 43
        const val RULE_insetsName: Int = 44
        const val RULE_dimension: Int = 45
        const val RULE_match: Int = 46
        const val RULE_exact: Int = 47
        const val RULE_viewAttr: Int = 48
        const val RULE_testTag: Int = 49
        const val RULE_alpha: Int = 50
        const val RULE_padding: Int = 51
        const val RULE_background: Int = 52
        const val RULE_backgroundValue: Int = 53
        const val RULE_border: Int = 54
        const val RULE_borderAttr: Int = 55
        const val RULE_widthExact: Int = 56
        const val RULE_dashSize: Int = 57
        const val RULE_dashGap: Int = 58
        const val RULE_cornersRadius: Int = 59
        const val RULE_corners: Int = 60
        const val RULE_cornerName: Int = 61
        const val RULE_color: Int = 62
        const val RULE_colorHEX: Int = 63
        const val RULE_isEnabled: Int = 64
        const val RULE_isVisible: Int = 65
        const val RULE_tapAttr: Int = 66
        const val RULE_onTap: Int = 67
        const val RULE_onLongTap: Int = 68
        const val RULE_onPressedChange: Int = 69
        const val RULE_tapExpression: Int = 70
        const val RULE_mapExpr: Int = 71
        const val RULE_filterExpr: Int = 72
        const val RULE_lambdaParams: Int = 73
        const val RULE_flowRowAttr: Int = 74
        const val RULE_maxLinesCount: Int = 75
        const val RULE_horizontalSpacing: Int = 76
        const val RULE_verticalSpacing: Int = 77
        const val RULE_textNode: Int = 78
        const val RULE_textAttr: Int = 79
        const val RULE_text: Int = 80
        const val RULE_textConfig: Int = 81
        const val RULE_configAttr: Int = 82
        const val RULE_fontSize: Int = 83
        const val RULE_fontStyle: Int = 84
        const val RULE_fontStyleValue: Int = 85
        const val RULE_isUnderline: Int = 86
        const val RULE_isStrikeThrough: Int = 87
        const val RULE_align: Int = 88
        const val RULE_alignValue: Int = 89
        const val RULE_overflow: Int = 90
        const val RULE_overflowValue: Int = 91
        const val RULE_maxLines: Int = 92
        const val RULE_lineHeight: Int = 93
        const val RULE_letterSpacing: Int = 94
        const val RULE_imageNode: Int = 95
        const val RULE_imageAttr: Int = 96
        const val RULE_source: Int = 97
        const val RULE_placeholder: Int = 98
        const val RULE_placeholderTint: Int = 99
        const val RULE_tint: Int = 100
        const val RULE_resizeMode: Int = 101
        const val RULE_resizeModeValue: Int = 102
        const val RULE_animateChanges: Int = 103
        const val RULE_animateChangesValue: Int = 104
        const val RULE_textFieldNode: Int = 105
        const val RULE_textFieldAttr: Int = 106
        const val RULE_textFieldConfig: Int = 107
        const val RULE_keyboardOptions: Int = 108
        const val RULE_keyboardOptionsValue: Int = 109
        const val RULE_capitalization: Int = 110
        const val RULE_capitalizationValue: Int = 111
        const val RULE_autoCorrect: Int = 112
        const val RULE_keyboardType: Int = 113
        const val RULE_keyboardTypeValue: Int = 114
        const val RULE_imeAction: Int = 115
        const val RULE_imeActionValue: Int = 116
        const val RULE_inputAccessoryAction: Int = 117
        const val RULE_isMultiline: Int = 118
        private fun makeRuleNames(): Array<String> {
            return arrayOf(
                "start",
                "fields",
                "typeValue",
                "fStringArray",
                "fBooleanArray",
                "fDoubleArray",
                "fLongArray",
                "fstringArrValue",
                "fbooleanArrValue",
                "fdoubleArrValue",
                "flongArrValue",
                "fStringDictionary",
                "fDoubleDictionary",
                "fLongDictionary",
                "fBooleanDictionary",
                "fstringDictValue",
                "fdoubleDictValue",
                "flongDictValue",
                "fbooleanDictValue",
                "layoutNode",
                "node",
                "box",
                "column",
                "row",
                "flowRow",
                "lazyColumn",
                "lazyRow",
                "item",
                "items",
                "attrExpression",
                "ifExpr",
                "condition",
                "consts",
                "fieldExpr",
                "ifValues",
                "layoutAttr",
                "width",
                "height",
                "weight",
                "gravity",
                "gravityExpression",
                "gravityValue",
                "margin",
                "insets",
                "insetsName",
                "dimension",
                "match",
                "exact",
                "viewAttr",
                "testTag",
                "alpha",
                "padding",
                "background",
                "backgroundValue",
                "border",
                "borderAttr",
                "widthExact",
                "dashSize",
                "dashGap",
                "cornersRadius",
                "corners",
                "cornerName",
                "color",
                "colorHEX",
                "isEnabled",
                "isVisible",
                "tapAttr",
                "onTap",
                "onLongTap",
                "onPressedChange",
                "tapExpression",
                "mapExpr",
                "filterExpr",
                "lambdaParams",
                "flowRowAttr",
                "maxLinesCount",
                "horizontalSpacing",
                "verticalSpacing",
                "textNode",
                "textAttr",
                "text",
                "textConfig",
                "configAttr",
                "fontSize",
                "fontStyle",
                "fontStyleValue",
                "isUnderline",
                "isStrikeThrough",
                "align",
                "alignValue",
                "overflow",
                "overflowValue",
                "maxLines",
                "lineHeight",
                "letterSpacing",
                "imageNode",
                "imageAttr",
                "source",
                "placeholder",
                "placeholderTint",
                "tint",
                "resizeMode",
                "resizeModeValue",
                "animateChanges",
                "animateChangesValue",
                "textFieldNode",
                "textFieldAttr",
                "textFieldConfig",
                "keyboardOptions",
                "keyboardOptionsValue",
                "capitalization",
                "capitalizationValue",
                "autoCorrect",
                "keyboardType",
                "keyboardTypeValue",
                "imeAction",
                "imeActionValue",
                "inputAccessoryAction",
                "isMultiline"
            )
        }

        val ruleNames: Array<String> = makeRuleNames()

        private fun makeLiteralNames(): Array<String?> {
            return arrayOf(
                null, "'Box'", "'Column'", "'FlowRow'", "'LazyColumn'", "'LazyRow'",
                "'Row'", "'Text'", "'TextField'", "'Image'", "'{'", "'}'", "'('", "')'",
                "'['", "']'", "'<'", "'>'", "'width'", "'height'", "'weight'", "'gravity'",
                "'margin'", "'testTag'", "'alpha'", "'padding'", "'background'", "'isEnabled'",
                "'isVisible'", "'border'", "'cornersRadius'", "'color'", "'dashSize'",
                "'dashGap'", "'text'", "'config'", "'textConfig'", "'fontSize'", "'fontStyle'",
                "'isUnderline'", "'isStrikeThrough'", "'align'", "'overflow'", "'maxLines'",
                "'lineHeight'", "'letterSpacing'", "'keyboardOptions'", "'capitalization'",
                "'autoCorrect'", "'keyboardType'", "'imeAction'", "'inputAccessoryAction'",
                "'isMultiline'", "'source'", "'placeholder'", "'placeholderTint'", "'tint'",
                "'resizeMode'", "'animateChanges'", "'maxLinesCount'", "'horizontalSpacing'",
                "'verticalSpacing'", "'val'", "'to'", "'map'", "'ifThen'", "'filter'",
                "'Array'", "'Dictionary'", "'String'", "'Boolean'", "'Double'", "'Long'",
                "'item'", "'items'", "'onTap'", "'onLongTap'", "'onPressedChange'", "'fill'",
                "'wrap'", "'justify'", "'ellipsis'", "'clip'", "'aspectFit'", "'scaleToFill'",
                "'aspectFill'", "'none'", "'crossFade'", "'.'", "','", "'\"'", "'#'",
                "'np'", "'ap'", "'+'", "'-'", "'='", "'=='", "'!='", "'->'", "'center'",
                "'left'", "'right'", "'top'", "'bottom'", "'leftTop'", "'rightTop'",
                "'leftBottom'", "'rightBottom'", "'all'", "'start'", "'end'", "'horizontal'",
                "'vertical'", "'regular'", "'bold'", "'extraBoldItalic'", "'boldItalic'",
                "'semiBold'", "'medium'", "'aliBold'", "'aliRegular'", "'aliLight'",
                "'characters'", "'words'", "'sentences'", "'ascii'", "'number'", "'phone'",
                "'uri'", "'email'", "'password'", "'numberPassword'", "'default'", "'go'",
                "'search'", "'send'", "'previous'", "'next'", "'done'", null, null, null,
                null, null, null, null, null, null, null, "'c'"
            )
        }

        private val _LITERAL_NAMES = makeLiteralNames()
        private fun makeSymbolicNames(): Array<String?> {
            return arrayOf(
                null,
                "BOX",
                "COLUMN",
                "FLOW_ROW",
                "LAZY_COLUMN",
                "LAZY_ROW",
                "ROW",
                "TEXT_NODE",
                "TEXT_FIELD_NODE",
                "IMAGE_NODE",
                "LEFT_FIGURE_BRACE",
                "RIGHT_FIGURE_BRACE",
                "LEFT_BRACE",
                "RIGHT_BRACE",
                "LEFT_SQUARE_BRACE",
                "RIGHT_SQUARE_BRACE",
                "LEFT_ANGLE_BRACE",
                "RIGHT_ANGLE_BRACE",
                "WIDTH",
                "HEIGHT",
                "WEIGHT",
                "GRAVITY",
                "MARGIN",
                "TEST_TAG",
                "ALPHA",
                "PADDING",
                "BACKGROUND",
                "IS_ENABLED",
                "IS_VISIBLE",
                "BORDER",
                "CORNERS_RADIUS",
                "COLOR",
                "DASH_SIZE",
                "DASH_GAP",
                "TEXT",
                "CONFIG",
                "TEXT_CONFIG",
                "FONT_SIZE",
                "FONT_STYLE",
                "IS_UNDERLINE",
                "IS_STRIKE_THROUGH",
                "ALIGN",
                "OVERFLOW",
                "MAX_LINES",
                "LINE_HEIGHT",
                "LETTER_SPACING",
                "KEYBOARD_OPTIONS",
                "CAPITALIZATION",
                "AUTO_CORRECT",
                "KEYBOARD_TYPE",
                "IME_ACTION",
                "INPUT_ACCESSORY_ACTION",
                "IS_MULTILINE",
                "SOURCE",
                "PLACEHOLDER",
                "PLACEHOLDER_TINT",
                "TINT",
                "RESIZE_MODE",
                "ANIMATE_CHANGES",
                "MAX_LINES_COUNT",
                "HORIZONTAL_SPACING",
                "VERTICAL_SPACING",
                "VAL",
                "TO",
                "MAP",
                "IF_THEN",
                "FILTER",
                "ARRAY",
                "DICTIONARY",
                "STRING_TYPE",
                "BOOLEAN_TYPE",
                "DOUBLE_TYPE",
                "LONG_TYPE",
                "ITEM",
                "ITEMS",
                "ON_TAP",
                "ON_LONG_TAP",
                "ON_PRESSED_CHANGE",
                "FILL",
                "WRAP",
                "JUSTIFY",
                "ELLIPSIS",
                "CLIP",
                "ASPECT_FIT",
                "SCALE_TO_FILL",
                "ASPECT_FILL",
                "NONE",
                "CROSS_FADE",
                "POINT",
                "COMMA",
                "DOUBLE_QUOTES",
                "LATTICE",
                "NP",
                "AP",
                "PLUS",
                "MINUS",
                "ASSIGN",
                "EQUAL",
                "NOT_EQUAL",
                "ARROW",
                "CENTER",
                "LEFT",
                "RIGHT",
                "TOP",
                "BOTTOM",
                "LEFT_TOP",
                "RIGHT_TOP",
                "LEFT_BOTTOM",
                "RIGHT_BOTTOM",
                "ALL",
                "START",
                "END",
                "HORIZONTAL",
                "VERTICAL",
                "REGULAR",
                "BOLD",
                "EXTRA_BOLD_ITALIC",
                "BOLD_ITALIC",
                "SEMI_BOLD",
                "MEDIUM",
                "ALI_BOLD",
                "ALI_REGULAR",
                "ALI_LIGHT",
                "CHARACTERS",
                "WORDS",
                "SENTENCES",
                "ASCII",
                "NUMBER",
                "PHONE",
                "URI",
                "EMAIL",
                "PASSWORD",
                "NUMBER_PASSWORD",
                "DEFAULT",
                "GO",
                "SEARCH",
                "SEND",
                "PREVIOUS",
                "NEXT",
                "DONE",
                "HEX",
                "STRING",
                "FSTRING",
                "BOOLEAN",
                "FBOOLEAN",
                "DOUBLE",
                "FDOUBLE",
                "LONG",
                "FLONG",
                "FIELD_NAME",
                "C",
                "WS"
            )
        }

        private val _SYMBOLIC_NAMES = makeSymbolicNames()
        val VOCABULARY: Vocabulary = VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES)


        @Deprecated("Use {@link #VOCABULARY} instead.")
        val tokenNames = Array(_SYMBOLIC_NAMES.size) {
            VOCABULARY.getLiteralName(it) ?: VOCABULARY.getSymbolicName(it) ?: "<INVALID>"
        }

        const val _serializedATN: String =
            "\u0004\u0001\u0097\u044a\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001" +
                    "\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004" +
                    "\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007" +
                    "\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b" +
                    "\u0002\u000c\u0007\u000c\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007" +
                    "\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007" +
                    "\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007" +
                    "\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007" +
                    "\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007" +
                    "\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007" +
                    "\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007" +
                    "\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007" +
                    "\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007" +
                    ",\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u0007" +
                    "1\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u0007" +
                    "6\u00027\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007" +
                    ";\u0002<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007" +
                    "@\u0002A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007" +
                    "E\u0002F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007" +
                    "J\u0002K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007" +
                    "O\u0002P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002S\u0007S\u0002T\u0007" +
                    "T\u0002U\u0007U\u0002V\u0007V\u0002W\u0007W\u0002X\u0007X\u0002Y\u0007" +
                    "Y\u0002Z\u0007Z\u0002[\u0007[\u0002\\\u0007\\\u0002]\u0007]\u0002^\u0007" +
                    "^\u0002_\u0007_\u0002`\u0007`\u0002a\u0007a\u0002b\u0007b\u0002c\u0007" +
                    "c\u0002d\u0007d\u0002e\u0007e\u0002f\u0007f\u0002g\u0007g\u0002h\u0007" +
                    "h\u0002i\u0007i\u0002j\u0007j\u0002k\u0007k\u0002l\u0007l\u0002m\u0007" +
                    "m\u0002n\u0007n\u0002o\u0007o\u0002p\u0007p\u0002q\u0007q\u0002r\u0007" +
                    "r\u0002s\u0007s\u0002t\u0007t\u0002u\u0007u\u0002v\u0007v\u0001\u0000" +
                    "\u0005\u0000\u00f0\b\u0000\n\u0000\u000c\u0000\u00f3\t\u0000\u0001\u0000\u0001" +
                    "\u0000\u0003\u0000\u00f7\b\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001" +
                    "\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001" +
                    "\u0002\u0003\u0002\u0103\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001" +
                    "\u0002\u0001\u0002\u0003\u0002\u010a\b\u0002\u0001\u0002\u0001\u0002\u0001" +
                    "\u0002\u0001\u0002\u0003\u0002\u0110\b\u0002\u0001\u0003\u0001\u0003\u0001" +
                    "\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001" +
                    "\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001" +
                    "\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0005\u0007\u0124\b\u0007\n" +
                    "\u0007\u000c\u0007\u0127\t\u0007\u0001\u0007\u0003\u0007\u012a\b\u0007\u0001" +
                    "\b\u0001\b\u0005\b\u012e\b\b\n\b\u000c\b\u0131\t\b\u0001\b\u0003\b\u0134\b" +
                    "\b\u0001\t\u0001\t\u0005\t\u0138\b\t\n\t\u000c\t\u013b\t\t\u0001\t\u0003\t" +
                    "\u013e\b\t\u0001\n\u0001\n\u0005\n\u0142\b\n\n\n\u000c\n\u0145\t\n\u0001\n" +
                    "\u0003\n\u0148\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000c\u0001\u000c\u0001\u000c\u0001\u000c\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e" +
                    "\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f" +
                    "\u0001\u000f\u0005\u000f\u015e\b\u000f\n\u000f\u000c\u000f\u0161\t\u000f\u0001" +
                    "\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0166\b\u000f\u0001\u0010\u0001" +
                    "\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u016c\b\u0010\n\u0010\u000c\u0010" +
                    "\u016f\t\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u0174\b" +
                    "\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u017a" +
                    "\b\u0011\n\u0011\u000c\u0011\u017d\t\u0011\u0001\u0011\u0001\u0011\u0001\u0011" +
                    "\u0003\u0011\u0182\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012" +
                    "\u0005\u0012\u0188\b\u0012\n\u0012\u000c\u0012\u018b\t\u0012\u0001\u0012\u0001" +
                    "\u0012\u0001\u0012\u0003\u0012\u0190\b\u0012\u0001\u0013\u0001\u0013\u0001" +
                    "\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0198\b\u0013\u0001" +
                    "\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u019d\b\u0014\u0001\u0015\u0001" +
                    "\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0005" +
                    "\u0015\u01a6\b\u0015\n\u0015\u000c\u0015\u01a9\t\u0015\u0001\u0015\u0001\u0015" +
                    "\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016" +
                    "\u0001\u0016\u0005\u0016\u01b4\b\u0016\n\u0016\u000c\u0016\u01b7\t\u0016\u0001" +
                    "\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001" +
                    "\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u01c2\b\u0017\n\u0017\u000c\u0017" +
                    "\u01c5\t\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018" +
                    "\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018" +
                    "\u01d1\b\u0018\n\u0018\u000c\u0018\u01d4\t\u0018\u0001\u0018\u0001\u0018\u0001" +
                    "\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001" +
                    "\u0019\u0005\u0019\u01df\b\u0019\n\u0019\u000c\u0019\u01e2\t\u0019\u0001\u0019" +
                    "\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a" +
                    "\u0001\u001a\u0001\u001a\u0005\u001a\u01ed\b\u001a\n\u001a\u000c\u001a\u01f0" +
                    "\t\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001" +
                    "\u001b\u0003\u001b\u01f8\b\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001" +
                    "\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0003" +
                    "\u001c\u0203\b\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0003" +
                    "\u001d\u0209\b\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001" +
                    "\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0003" +
                    "\u001f\u0215\b\u001f\u0001 \u0001 \u0001!\u0001!\u0001!\u0001!\u0001!" +
                    "\u0003!\u021e\b!\u0001\"\u0001\"\u0003\"\u0222\b\"\u0001\"\u0001\"\u0001" +
                    "\"\u0003\"\u0227\b\"\u0003\"\u0229\b\"\u0001#\u0001#\u0001#\u0001#\u0001" +
                    "#\u0003#\u0230\b#\u0001$\u0001$\u0001$\u0001$\u0001$\u0001%\u0001%\u0001" +
                    "%\u0001%\u0001%\u0001&\u0001&\u0001&\u0001&\u0003&\u0240\b&\u0001&\u0001" +
                    "&\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001(\u0001(\u0001(\u0001(" +
                    "\u0001(\u0003(\u024e\b(\u0001)\u0001)\u0001*\u0001*\u0001*\u0005*\u0255" +
                    "\b*\n*\u000c*\u0258\t*\u0001*\u0001*\u0001+\u0001+\u0001+\u0001+\u0001+\u0001" +
                    ",\u0001,\u0001-\u0001-\u0003-\u0265\b-\u0001.\u0001.\u0001/\u0001/\u0001" +
                    "/\u0001/\u00010\u00010\u00010\u00010\u00010\u00010\u00030\u0273\b0\u0001" +
                    "1\u00011\u00011\u00011\u00031\u0279\b1\u00011\u00011\u00012\u00012\u0001" +
                    "2\u00012\u00032\u0281\b2\u00012\u00012\u00013\u00013\u00013\u00053\u0288" +
                    "\b3\n3\u000c3\u028b\t3\u00013\u00013\u00014\u00014\u00014\u00054\u0292\b4" +
                    "\n4\u000c4\u0295\t4\u00014\u00014\u00015\u00015\u00015\u00035\u029c\b5\u0001" +
                    "6\u00016\u00016\u00056\u02a1\b6\n6\u000c6\u02a4\t6\u00016\u00016\u00017\u0001" +
                    "7\u00017\u00017\u00037\u02ac\b7\u00018\u00018\u00018\u00018\u00018\u0001" +
                    "9\u00019\u00019\u00019\u00019\u0001:\u0001:\u0001:\u0001:\u0001:\u0001" +
                    ";\u0001;\u0001;\u0005;\u02c0\b;\n;\u000c;\u02c3\t;\u0001;\u0001;\u0001<\u0001" +
                    "<\u0001<\u0001<\u0001<\u0001=\u0001=\u0001>\u0001>\u0001>\u0001>\u0001" +
                    ">\u0001?\u0001?\u0001?\u0001?\u0003?\u02d7\b?\u0001?\u0001?\u0001@\u0001" +
                    "@\u0001@\u0001@\u0003@\u02df\b@\u0001@\u0001@\u0001A\u0001A\u0001A\u0001" +
                    "A\u0003A\u02e7\bA\u0001A\u0001A\u0001B\u0001B\u0001B\u0003B\u02ee\bB\u0001" +
                    "C\u0001C\u0001C\u0004C\u02f3\bC\u000bC\u000cC\u02f4\u0001C\u0001C\u0001D\u0001" +
                    "D\u0001D\u0004D\u02fc\bD\u000bD\u000cD\u02fd\u0001D\u0001D\u0001E\u0001E\u0001" +
                    "E\u0004E\u0305\bE\u000bE\u000cE\u0306\u0001E\u0001E\u0001F\u0001F\u0001F\u0001" +
                    "F\u0001F\u0001F\u0001F\u0003F\u0312\bF\u0001G\u0001G\u0001G\u0001G\u0001" +
                    "G\u0001G\u0001G\u0001G\u0001G\u0001G\u0001G\u0003G\u031f\bG\u0001H\u0001" +
                    "H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0003" +
                    "H\u032c\bH\u0001I\u0001I\u0001I\u0001I\u0003I\u0332\bI\u0001J\u0001J\u0001" +
                    "J\u0003J\u0337\bJ\u0001K\u0001K\u0001K\u0001K\u0003K\u033d\bK\u0001K\u0001" +
                    "K\u0001L\u0001L\u0001L\u0001L\u0001L\u0001M\u0001M\u0001M\u0001M\u0001" +
                    "M\u0001N\u0001N\u0001N\u0001N\u0001N\u0001N\u0005N\u0351\bN\nN\u000cN\u0354" +
                    "\tN\u0001N\u0001N\u0001O\u0001O\u0001O\u0001O\u0001O\u0001O\u0001O\u0003" +
                    "O\u035f\bO\u0001P\u0001P\u0001P\u0001P\u0003P\u0365\bP\u0001P\u0001P\u0001" +
                    "Q\u0001Q\u0001Q\u0005Q\u036c\bQ\nQ\u000cQ\u036f\tQ\u0001Q\u0001Q\u0001R\u0001" +
                    "R\u0001R\u0001R\u0001R\u0003R\u0378\bR\u0001S\u0001S\u0001S\u0001S\u0001" +
                    "S\u0001T\u0001T\u0001T\u0001T\u0001T\u0001U\u0001U\u0001V\u0001V\u0001" +
                    "V\u0001V\u0003V\u038a\bV\u0001V\u0001V\u0001W\u0001W\u0001W\u0001W\u0003" +
                    "W\u0392\bW\u0001W\u0001W\u0001X\u0001X\u0001X\u0001X\u0001X\u0001Y\u0001" +
                    "Y\u0001Z\u0001Z\u0001Z\u0001Z\u0001Z\u0001[\u0001[\u0001\\\u0001\\\u0001" +
                    "\\\u0001\\\u0003\\\u03a8\b\\\u0001\\\u0001\\\u0001]\u0001]\u0001]\u0001" +
                    "]\u0001]\u0001^\u0001^\u0001^\u0001^\u0001^\u0001_\u0001_\u0001_\u0001" +
                    "_\u0001_\u0001_\u0005_\u03bc\b_\n_\u000c_\u03bf\t_\u0001_\u0001_\u0001`\u0001" +
                    "`\u0001`\u0001`\u0001`\u0001`\u0003`\u03c9\b`\u0001a\u0001a\u0001a\u0001" +
                    "a\u0003a\u03cf\ba\u0001a\u0001a\u0001b\u0001b\u0001b\u0001b\u0001b\u0001" +
                    "c\u0001c\u0001c\u0001c\u0001c\u0001d\u0001d\u0001d\u0001d\u0001d\u0001" +
                    "e\u0001e\u0001e\u0001e\u0001e\u0001f\u0001f\u0001g\u0001g\u0001g\u0001" +
                    "g\u0001g\u0001h\u0001h\u0001i\u0001i\u0001i\u0001i\u0001i\u0001i\u0005" +
                    "i\u03f6\bi\ni\u000ci\u03f9\ti\u0001i\u0001i\u0001j\u0001j\u0001j\u0001j\u0001" +
                    "j\u0001j\u0003j\u0403\bj\u0001k\u0001k\u0001k\u0005k\u0408\bk\nk\u000ck\u040b" +
                    "\tk\u0001k\u0001k\u0001l\u0001l\u0001l\u0005l\u0412\bl\nl\u000cl\u0415\tl" +
                    "\u0001l\u0001l\u0001m\u0001m\u0001m\u0001m\u0001m\u0003m\u041e\bm\u0001" +
                    "n\u0001n\u0001n\u0001n\u0001n\u0001o\u0001o\u0001p\u0001p\u0001p\u0001" +
                    "p\u0003p\u042b\bp\u0001p\u0001p\u0001q\u0001q\u0001q\u0001q\u0001q\u0001" +
                    "r\u0001r\u0001s\u0001s\u0001s\u0001s\u0001s\u0001t\u0001t\u0001u\u0001" +
                    "u\u0001u\u0001u\u0001u\u0001v\u0001v\u0001v\u0001v\u0003v\u0446\bv\u0001" +
                    "v\u0001v\u0001v\u0000\u0000w\u0000\u0002\u0004\u0006\b\n\u000c\u000e\u0010" +
                    "\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPR" +
                    "TVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e" +
                    "\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6" +
                    "\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be" +
                    "\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6" +
                    "\u00d8\u00da\u00dc\u00de\u00e0\u00e2\u00e4\u00e6\u00e8\u00ea\u00ec\u0000" +
                    "\u0011\u0001\u0000ab\u0004\u0000\u008e\u008e\u0090\u0090\u0092\u0092\u0094" +
                    "\u0094\u0002\u0000\u008d\u008d\u0093\u0093\u0001\u0000dh\u0003\u0000e" +
                    "hmmpq\u0001\u0000NO\u0002\u0000\u0091\u0091\u0093\u0093\u0001\u0000\\" +
                    "]\u0001\u0000im\u0001\u0000rz\u0003\u0000PPddno\u0001\u0000QR\u0001\u0000" +
                    "SU\u0001\u0000VW\u0002\u0000VV{}\u0002\u0000\"\"~\u0084\u0002\u0000VV" +
                    "\u0085\u008b\u0475\u0000\u00f1\u0001\u0000\u0000\u0000\u0002\u00f8\u0001" +
                    "\u0000\u0000\u0000\u0004\u010f\u0001\u0000\u0000\u0000\u0006\u0111\u0001" +
                    "\u0000\u0000\u0000\b\u0115\u0001\u0000\u0000\u0000\n\u0119\u0001\u0000" +
                    "\u0000\u0000\u000c\u011d\u0001\u0000\u0000\u0000\u000e\u0129\u0001\u0000\u0000" +
                    "\u0000\u0010\u0133\u0001\u0000\u0000\u0000\u0012\u013d\u0001\u0000\u0000" +
                    "\u0000\u0014\u0147\u0001\u0000\u0000\u0000\u0016\u0149\u0001\u0000\u0000" +
                    "\u0000\u0018\u014d\u0001\u0000\u0000\u0000\u001a\u0151\u0001\u0000\u0000" +
                    "\u0000\u001c\u0155\u0001\u0000\u0000\u0000\u001e\u0165\u0001\u0000\u0000" +
                    "\u0000 \u0173\u0001\u0000\u0000\u0000\"\u0181\u0001\u0000\u0000\u0000" +
                    "$\u018f\u0001\u0000\u0000\u0000&\u0197\u0001\u0000\u0000\u0000(\u019c" +
                    "\u0001\u0000\u0000\u0000*\u019e\u0001\u0000\u0000\u0000,\u01ac\u0001\u0000" +
                    "\u0000\u0000.\u01ba\u0001\u0000\u0000\u00000\u01c8\u0001\u0000\u0000\u0000" +
                    "2\u01d7\u0001\u0000\u0000\u00004\u01e5\u0001\u0000\u0000\u00006\u01f3" +
                    "\u0001\u0000\u0000\u00008\u01fb\u0001\u0000\u0000\u0000:\u0208\u0001\u0000" +
                    "\u0000\u0000<\u020a\u0001\u0000\u0000\u0000>\u0211\u0001\u0000\u0000\u0000" +
                    "@\u0216\u0001\u0000\u0000\u0000B\u021d\u0001\u0000\u0000\u0000D\u0221" +
                    "\u0001\u0000\u0000\u0000F\u022f\u0001\u0000\u0000\u0000H\u0231\u0001\u0000" +
                    "\u0000\u0000J\u0236\u0001\u0000\u0000\u0000L\u023b\u0001\u0000\u0000\u0000" +
                    "N\u0243\u0001\u0000\u0000\u0000P\u024d\u0001\u0000\u0000\u0000R\u024f" +
                    "\u0001\u0000\u0000\u0000T\u0251\u0001\u0000\u0000\u0000V\u025b\u0001\u0000" +
                    "\u0000\u0000X\u0260\u0001\u0000\u0000\u0000Z\u0264\u0001\u0000\u0000\u0000" +
                    "\\\u0266\u0001\u0000\u0000\u0000^\u0268\u0001\u0000\u0000\u0000`\u0272" +
                    "\u0001\u0000\u0000\u0000b\u0274\u0001\u0000\u0000\u0000d\u027c\u0001\u0000" +
                    "\u0000\u0000f\u0284\u0001\u0000\u0000\u0000h\u028e\u0001\u0000\u0000\u0000" +
                    "j\u029b\u0001\u0000\u0000\u0000l\u029d\u0001\u0000\u0000\u0000n\u02ab" +
                    "\u0001\u0000\u0000\u0000p\u02ad\u0001\u0000\u0000\u0000r\u02b2\u0001\u0000" +
                    "\u0000\u0000t\u02b7\u0001\u0000\u0000\u0000v\u02bc\u0001\u0000\u0000\u0000" +
                    "x\u02c6\u0001\u0000\u0000\u0000z\u02cb\u0001\u0000\u0000\u0000|\u02cd" +
                    "\u0001\u0000\u0000\u0000~\u02d2\u0001\u0000\u0000\u0000\u0080\u02da\u0001" +
                    "\u0000\u0000\u0000\u0082\u02e2\u0001\u0000\u0000\u0000\u0084\u02ed\u0001" +
                    "\u0000\u0000\u0000\u0086\u02ef\u0001\u0000\u0000\u0000\u0088\u02f8\u0001" +
                    "\u0000\u0000\u0000\u008a\u0301\u0001\u0000\u0000\u0000\u008c\u030a\u0001" +
                    "\u0000\u0000\u0000\u008e\u0313\u0001\u0000\u0000\u0000\u0090\u0320\u0001" +
                    "\u0000\u0000\u0000\u0092\u0331\u0001\u0000\u0000\u0000\u0094\u0336\u0001" +
                    "\u0000\u0000\u0000\u0096\u0338\u0001\u0000\u0000\u0000\u0098\u0340\u0001" +
                    "\u0000\u0000\u0000\u009a\u0345\u0001\u0000\u0000\u0000\u009c\u034a\u0001" +
                    "\u0000\u0000\u0000\u009e\u035e\u0001\u0000\u0000\u0000\u00a0\u0360\u0001" +
                    "\u0000\u0000\u0000\u00a2\u0368\u0001\u0000\u0000\u0000\u00a4\u0377\u0001" +
                    "\u0000\u0000\u0000\u00a6\u0379\u0001\u0000\u0000\u0000\u00a8\u037e\u0001" +
                    "\u0000\u0000\u0000\u00aa\u0383\u0001\u0000\u0000\u0000\u00ac\u0385\u0001" +
                    "\u0000\u0000\u0000\u00ae\u038d\u0001\u0000\u0000\u0000\u00b0\u0395\u0001" +
                    "\u0000\u0000\u0000\u00b2\u039a\u0001\u0000\u0000\u0000\u00b4\u039c\u0001" +
                    "\u0000\u0000\u0000\u00b6\u03a1\u0001\u0000\u0000\u0000\u00b8\u03a3\u0001" +
                    "\u0000\u0000\u0000\u00ba\u03ab\u0001\u0000\u0000\u0000\u00bc\u03b0\u0001" +
                    "\u0000\u0000\u0000\u00be\u03b5\u0001\u0000\u0000\u0000\u00c0\u03c8\u0001" +
                    "\u0000\u0000\u0000\u00c2\u03ca\u0001\u0000\u0000\u0000\u00c4\u03d2\u0001" +
                    "\u0000\u0000\u0000\u00c6\u03d7\u0001\u0000\u0000\u0000\u00c8\u03dc\u0001" +
                    "\u0000\u0000\u0000\u00ca\u03e1\u0001\u0000\u0000\u0000\u00cc\u03e6\u0001" +
                    "\u0000\u0000\u0000\u00ce\u03e8\u0001\u0000\u0000\u0000\u00d0\u03ed\u0001" +
                    "\u0000\u0000\u0000\u00d2\u03ef\u0001\u0000\u0000\u0000\u00d4\u0402\u0001" +
                    "\u0000\u0000\u0000\u00d6\u0404\u0001\u0000\u0000\u0000\u00d8\u040e\u0001" +
                    "\u0000\u0000\u0000\u00da\u041d\u0001\u0000\u0000\u0000\u00dc\u041f\u0001" +
                    "\u0000\u0000\u0000\u00de\u0424\u0001\u0000\u0000\u0000\u00e0\u0426\u0001" +
                    "\u0000\u0000\u0000\u00e2\u042e\u0001\u0000\u0000\u0000\u00e4\u0433\u0001" +
                    "\u0000\u0000\u0000\u00e6\u0435\u0001\u0000\u0000\u0000\u00e8\u043a\u0001" +
                    "\u0000\u0000\u0000\u00ea\u043c\u0001\u0000\u0000\u0000\u00ec\u0441\u0001" +
                    "\u0000\u0000\u0000\u00ee\u00f0\u0003\u0002\u0001\u0000\u00ef\u00ee\u0001" +
                    "\u0000\u0000\u0000\u00f0\u00f3\u0001\u0000\u0000\u0000\u00f1\u00ef\u0001" +
                    "\u0000\u0000\u0000\u00f1\u00f2\u0001\u0000\u0000\u0000\u00f2\u00f6\u0001" +
                    "\u0000\u0000\u0000\u00f3\u00f1\u0001\u0000\u0000\u0000\u00f4\u00f7\u0003" +
                    "&\u0013\u0000\u00f5\u00f7\u0003(\u0014\u0000\u00f6\u00f4\u0001\u0000\u0000" +
                    "\u0000\u00f6\u00f5\u0001\u0000\u0000\u0000\u00f7\u0001\u0001\u0000\u0000" +
                    "\u0000\u00f8\u00f9\u0005>\u0000\u0000\u00f9\u00fa\u0005\u0095\u0000\u0000" +
                    "\u00fa\u00fb\u0005`\u0000\u0000\u00fb\u00fc\u0003\u0004\u0002\u0000\u00fc" +
                    "\u0003\u0001\u0000\u0000\u0000\u00fd\u0102\u0005C\u0000\u0000\u00fe\u0103" +
                    "\u0003\u0006\u0003\u0000\u00ff\u0103\u0003\b\u0004\u0000\u0100\u0103\u0003" +
                    "\n\u0005\u0000\u0101\u0103\u0003\u000c\u0006\u0000\u0102\u00fe\u0001\u0000" +
                    "\u0000\u0000\u0102\u00ff\u0001\u0000\u0000\u0000\u0102\u0100\u0001\u0000" +
                    "\u0000\u0000\u0102\u0101\u0001\u0000\u0000\u0000\u0103\u0110\u0001\u0000" +
                    "\u0000\u0000\u0104\u0109\u0005D\u0000\u0000\u0105\u010a\u0003\u0016\u000b" +
                    "\u0000\u0106\u010a\u0003\u0018\u000c\u0000\u0107\u010a\u0003\u001a\r\u0000" +
                    "\u0108\u010a\u0003\u001c\u000e\u0000\u0109\u0105\u0001\u0000\u0000\u0000" +
                    "\u0109\u0106\u0001\u0000\u0000\u0000\u0109\u0107\u0001\u0000\u0000\u0000" +
                    "\u0109\u0108\u0001\u0000\u0000\u0000\u010a\u0110\u0001\u0000\u0000\u0000" +
                    "\u010b\u0110\u0005\u0090\u0000\u0000\u010c\u0110\u0005\u0094\u0000\u0000" +
                    "\u010d\u0110\u0005\u0092\u0000\u0000\u010e\u0110\u0005\u008e\u0000\u0000" +
                    "\u010f\u00fd\u0001\u0000\u0000\u0000\u010f\u0104\u0001\u0000\u0000\u0000" +
                    "\u010f\u010b\u0001\u0000\u0000\u0000\u010f\u010c\u0001\u0000\u0000\u0000" +
                    "\u010f\u010d\u0001\u0000\u0000\u0000\u010f\u010e\u0001\u0000\u0000\u0000" +
                    "\u0110\u0005\u0001\u0000\u0000\u0000\u0111\u0112\u0005\u000c\u0000\u0000\u0112" +
                    "\u0113\u0003\u000e\u0007\u0000\u0113\u0114\u0005\r\u0000\u0000\u0114\u0007" +
                    "\u0001\u0000\u0000\u0000\u0115\u0116\u0005\u000c\u0000\u0000\u0116\u0117\u0003" +
                    "\u0010\b\u0000\u0117\u0118\u0005\r\u0000\u0000\u0118\t\u0001\u0000\u0000" +
                    "\u0000\u0119\u011a\u0005\u000c\u0000\u0000\u011a\u011b\u0003\u0012\t\u0000" +
                    "\u011b\u011c\u0005\r\u0000\u0000\u011c\u000b\u0001\u0000\u0000\u0000\u011d" +
                    "\u011e\u0005\u000c\u0000\u0000\u011e\u011f\u0003\u0014\n\u0000\u011f\u0120" +
                    "\u0005\r\u0000\u0000\u0120\r\u0001\u0000\u0000\u0000\u0121\u0122\u0005" +
                    "\u008e\u0000\u0000\u0122\u0124\u0005Y\u0000\u0000\u0123\u0121\u0001\u0000" +
                    "\u0000\u0000\u0124\u0127\u0001\u0000\u0000\u0000\u0125\u0123\u0001\u0000" +
                    "\u0000\u0000\u0125\u0126\u0001\u0000\u0000\u0000\u0126\u0128\u0001\u0000" +
                    "\u0000\u0000\u0127\u0125\u0001\u0000\u0000\u0000\u0128\u012a\u0005\u008e" +
                    "\u0000\u0000\u0129\u0125\u0001\u0000\u0000\u0000\u0129\u012a\u0001\u0000" +
                    "\u0000\u0000\u012a\u000f\u0001\u0000\u0000\u0000\u012b\u012c\u0005\u0090" +
                    "\u0000\u0000\u012c\u012e\u0005Y\u0000\u0000\u012d\u012b\u0001\u0000\u0000" +
                    "\u0000\u012e\u0131\u0001\u0000\u0000\u0000\u012f\u012d\u0001\u0000\u0000" +
                    "\u0000\u012f\u0130\u0001\u0000\u0000\u0000\u0130\u0132\u0001\u0000\u0000" +
                    "\u0000\u0131\u012f\u0001\u0000\u0000\u0000\u0132\u0134\u0005\u0090\u0000" +
                    "\u0000\u0133\u012f\u0001\u0000\u0000\u0000\u0133\u0134\u0001\u0000\u0000" +
                    "\u0000\u0134\u0011\u0001\u0000\u0000\u0000\u0135\u0136\u0005\u0092\u0000" +
                    "\u0000\u0136\u0138\u0005Y\u0000\u0000\u0137\u0135\u0001\u0000\u0000\u0000" +
                    "\u0138\u013b\u0001\u0000\u0000\u0000\u0139\u0137\u0001\u0000\u0000\u0000" +
                    "\u0139\u013a\u0001\u0000\u0000\u0000\u013a\u013c\u0001\u0000\u0000\u0000" +
                    "\u013b\u0139\u0001\u0000\u0000\u0000\u013c\u013e\u0005\u0092\u0000\u0000" +
                    "\u013d\u0139\u0001\u0000\u0000\u0000\u013d\u013e\u0001\u0000\u0000\u0000" +
                    "\u013e\u0013\u0001\u0000\u0000\u0000\u013f\u0140\u0005\u0094\u0000\u0000" +
                    "\u0140\u0142\u0005Y\u0000\u0000\u0141\u013f\u0001\u0000\u0000\u0000\u0142" +
                    "\u0145\u0001\u0000\u0000\u0000\u0143\u0141\u0001\u0000\u0000\u0000\u0143" +
                    "\u0144\u0001\u0000\u0000\u0000\u0144\u0146\u0001\u0000\u0000\u0000\u0145" +
                    "\u0143\u0001\u0000\u0000\u0000\u0146\u0148\u0005\u0094\u0000\u0000\u0147" +
                    "\u0143\u0001\u0000\u0000\u0000\u0147\u0148\u0001\u0000\u0000\u0000\u0148" +
                    "\u0015\u0001\u0000\u0000\u0000\u0149\u014a\u0005\u000c\u0000\u0000\u014a\u014b" +
                    "\u0003\u001e\u000f\u0000\u014b\u014c\u0005\r\u0000\u0000\u014c\u0017\u0001" +
                    "\u0000\u0000\u0000\u014d\u014e\u0005\u000c\u0000\u0000\u014e\u014f\u0003 " +
                    "\u0010\u0000\u014f\u0150\u0005\r\u0000\u0000\u0150\u0019\u0001\u0000\u0000" +
                    "\u0000\u0151\u0152\u0005\u000c\u0000\u0000\u0152\u0153\u0003\"\u0011\u0000" +
                    "\u0153\u0154\u0005\r\u0000\u0000\u0154\u001b\u0001\u0000\u0000\u0000\u0155" +
                    "\u0156\u0005\u000c\u0000\u0000\u0156\u0157\u0003$\u0012\u0000\u0157\u0158" +
                    "\u0005\r\u0000\u0000\u0158\u001d\u0001\u0000\u0000\u0000\u0159\u015a\u0005" +
                    "\u008e\u0000\u0000\u015a\u015b\u0005?\u0000\u0000\u015b\u015c\u0005\u008e" +
                    "\u0000\u0000\u015c\u015e\u0005Y\u0000\u0000\u015d\u0159\u0001\u0000\u0000" +
                    "\u0000\u015e\u0161\u0001\u0000\u0000\u0000\u015f\u015d\u0001\u0000\u0000" +
                    "\u0000\u015f\u0160\u0001\u0000\u0000\u0000\u0160\u0162\u0001\u0000\u0000" +
                    "\u0000\u0161\u015f\u0001\u0000\u0000\u0000\u0162\u0163\u0005\u008e\u0000" +
                    "\u0000\u0163\u0164\u0005?\u0000\u0000\u0164\u0166\u0005\u008e\u0000\u0000" +
                    "\u0165\u015f\u0001\u0000\u0000\u0000\u0165\u0166\u0001\u0000\u0000\u0000" +
                    "\u0166\u001f\u0001\u0000\u0000\u0000\u0167\u0168\u0005\u008e\u0000\u0000" +
                    "\u0168\u0169\u0005?\u0000\u0000\u0169\u016a\u0005\u0092\u0000\u0000\u016a" +
                    "\u016c\u0005Y\u0000\u0000\u016b\u0167\u0001\u0000\u0000\u0000\u016c\u016f" +
                    "\u0001\u0000\u0000\u0000\u016d\u016b\u0001\u0000\u0000\u0000\u016d\u016e" +
                    "\u0001\u0000\u0000\u0000\u016e\u0170\u0001\u0000\u0000\u0000\u016f\u016d" +
                    "\u0001\u0000\u0000\u0000\u0170\u0171\u0005\u008e\u0000\u0000\u0171\u0172" +
                    "\u0005?\u0000\u0000\u0172\u0174\u0005\u0092\u0000\u0000\u0173\u016d\u0001" +
                    "\u0000\u0000\u0000\u0173\u0174\u0001\u0000\u0000\u0000\u0174!\u0001\u0000" +
                    "\u0000\u0000\u0175\u0176\u0005\u008e\u0000\u0000\u0176\u0177\u0005?\u0000" +
                    "\u0000\u0177\u0178\u0005\u0094\u0000\u0000\u0178\u017a\u0005Y\u0000\u0000" +
                    "\u0179\u0175\u0001\u0000\u0000\u0000\u017a\u017d\u0001\u0000\u0000\u0000" +
                    "\u017b\u0179\u0001\u0000\u0000\u0000\u017b\u017c\u0001\u0000\u0000\u0000" +
                    "\u017c\u017e\u0001\u0000\u0000\u0000\u017d\u017b\u0001\u0000\u0000\u0000" +
                    "\u017e\u017f\u0005\u008e\u0000\u0000\u017f\u0180\u0005?\u0000\u0000\u0180" +
                    "\u0182\u0005\u0094\u0000\u0000\u0181\u017b\u0001\u0000\u0000\u0000\u0181" +
                    "\u0182\u0001\u0000\u0000\u0000\u0182#\u0001\u0000\u0000\u0000\u0183\u0184" +
                    "\u0005\u008e\u0000\u0000\u0184\u0185\u0005?\u0000\u0000\u0185\u0186\u0005" +
                    "\u0090\u0000\u0000\u0186\u0188\u0005Y\u0000\u0000\u0187\u0183\u0001\u0000" +
                    "\u0000\u0000\u0188\u018b\u0001\u0000\u0000\u0000\u0189\u0187\u0001\u0000" +
                    "\u0000\u0000\u0189\u018a\u0001\u0000\u0000\u0000\u018a\u018c\u0001\u0000" +
                    "\u0000\u0000\u018b\u0189\u0001\u0000\u0000\u0000\u018c\u018d\u0005\u008e" +
                    "\u0000\u0000\u018d\u018e\u0005?\u0000\u0000\u018e\u0190\u0005\u0090\u0000" +
                    "\u0000\u018f\u0189\u0001\u0000\u0000\u0000\u018f\u0190\u0001\u0000\u0000" +
                    "\u0000\u0190%\u0001\u0000\u0000\u0000\u0191\u0198\u0003*\u0015\u0000\u0192" +
                    "\u0198\u0003,\u0016\u0000\u0193\u0198\u0003.\u0017\u0000\u0194\u0198\u0003" +
                    "0\u0018\u0000\u0195\u0198\u00032\u0019\u0000\u0196\u0198\u00034\u001a" +
                    "\u0000\u0197\u0191\u0001\u0000\u0000\u0000\u0197\u0192\u0001\u0000\u0000" +
                    "\u0000\u0197\u0193\u0001\u0000\u0000\u0000\u0197\u0194\u0001\u0000\u0000" +
                    "\u0000\u0197\u0195\u0001\u0000\u0000\u0000\u0197\u0196\u0001\u0000\u0000" +
                    "\u0000\u0198\'\u0001\u0000\u0000\u0000\u0199\u019d\u0003\u009cN\u0000" +
                    "\u019a\u019d\u0003\u00be_\u0000\u019b\u019d\u0003\u00d2i\u0000\u019c\u0199" +
                    "\u0001\u0000\u0000\u0000\u019c\u019a\u0001\u0000\u0000\u0000\u019c\u019b" +
                    "\u0001\u0000\u0000\u0000\u019d)\u0001\u0000\u0000\u0000\u019e\u019f\u0005" +
                    "\u0001\u0000\u0000\u019f\u01a7\u0005\n\u0000\u0000\u01a0\u01a6\u0003F" +
                    "#\u0000\u01a1\u01a6\u0003`0\u0000\u01a2\u01a6\u0003\u0084B\u0000\u01a3" +
                    "\u01a6\u0003&\u0013\u0000\u01a4\u01a6\u0003(\u0014\u0000\u01a5\u01a0\u0001" +
                    "\u0000\u0000\u0000\u01a5\u01a1\u0001\u0000\u0000\u0000\u01a5\u01a2\u0001" +
                    "\u0000\u0000\u0000\u01a5\u01a3\u0001\u0000\u0000\u0000\u01a5\u01a4\u0001" +
                    "\u0000\u0000\u0000\u01a6\u01a9\u0001\u0000\u0000\u0000\u01a7\u01a5\u0001" +
                    "\u0000\u0000\u0000\u01a7\u01a8\u0001\u0000\u0000\u0000\u01a8\u01aa\u0001" +
                    "\u0000\u0000\u0000\u01a9\u01a7\u0001\u0000\u0000\u0000\u01aa\u01ab\u0005" +
                    "\u000b\u0000\u0000\u01ab+\u0001\u0000\u0000\u0000\u01ac\u01ad\u0005\u0002" +
                    "\u0000\u0000\u01ad\u01b5\u0005\n\u0000\u0000\u01ae\u01b4\u0003F#\u0000" +
                    "\u01af\u01b4\u0003`0\u0000\u01b0\u01b4\u0003\u0084B\u0000\u01b1\u01b4" +
                    "\u0003&\u0013\u0000\u01b2\u01b4\u0003(\u0014\u0000\u01b3\u01ae\u0001\u0000" +
                    "\u0000\u0000\u01b3\u01af\u0001\u0000\u0000\u0000\u01b3\u01b0\u0001\u0000" +
                    "\u0000\u0000\u01b3\u01b1\u0001\u0000\u0000\u0000\u01b3\u01b2\u0001\u0000" +
                    "\u0000\u0000\u01b4\u01b7\u0001\u0000\u0000\u0000\u01b5\u01b3\u0001\u0000" +
                    "\u0000\u0000\u01b5\u01b6\u0001\u0000\u0000\u0000\u01b6\u01b8\u0001\u0000" +
                    "\u0000\u0000\u01b7\u01b5\u0001\u0000\u0000\u0000\u01b8\u01b9\u0005\u000b" +
                    "\u0000\u0000\u01b9-\u0001\u0000\u0000\u0000\u01ba\u01bb\u0005\u0006\u0000" +
                    "\u0000\u01bb\u01c3\u0005\n\u0000\u0000\u01bc\u01c2\u0003F#\u0000\u01bd" +
                    "\u01c2\u0003`0\u0000\u01be\u01c2\u0003\u0084B\u0000\u01bf\u01c2\u0003" +
                    "&\u0013\u0000\u01c0\u01c2\u0003(\u0014\u0000\u01c1\u01bc\u0001\u0000\u0000" +
                    "\u0000\u01c1\u01bd\u0001\u0000\u0000\u0000\u01c1\u01be\u0001\u0000\u0000" +
                    "\u0000\u01c1\u01bf\u0001\u0000\u0000\u0000\u01c1\u01c0\u0001\u0000\u0000" +
                    "\u0000\u01c2\u01c5\u0001\u0000\u0000\u0000\u01c3\u01c1\u0001\u0000\u0000" +
                    "\u0000\u01c3\u01c4\u0001\u0000\u0000\u0000\u01c4\u01c6\u0001\u0000\u0000" +
                    "\u0000\u01c5\u01c3\u0001\u0000\u0000\u0000\u01c6\u01c7\u0005\u000b\u0000" +
                    "\u0000\u01c7/\u0001\u0000\u0000\u0000\u01c8\u01c9\u0005\u0003\u0000\u0000" +
                    "\u01c9\u01d2\u0005\n\u0000\u0000\u01ca\u01d1\u0003F#\u0000\u01cb\u01d1" +
                    "\u0003`0\u0000\u01cc\u01d1\u0003\u0084B\u0000\u01cd\u01d1\u0003\u0094" +
                    "J\u0000\u01ce\u01d1\u0003&\u0013\u0000\u01cf\u01d1\u0003(\u0014\u0000" +
                    "\u01d0\u01ca\u0001\u0000\u0000\u0000\u01d0\u01cb\u0001\u0000\u0000\u0000" +
                    "\u01d0\u01cc\u0001\u0000\u0000\u0000\u01d0\u01cd\u0001\u0000\u0000\u0000" +
                    "\u01d0\u01ce\u0001\u0000\u0000\u0000\u01d0\u01cf\u0001\u0000\u0000\u0000" +
                    "\u01d1\u01d4\u0001\u0000\u0000\u0000\u01d2\u01d0\u0001\u0000\u0000\u0000" +
                    "\u01d2\u01d3\u0001\u0000\u0000\u0000\u01d3\u01d5\u0001\u0000\u0000\u0000" +
                    "\u01d4\u01d2\u0001\u0000\u0000\u0000\u01d5\u01d6\u0005\u000b\u0000\u0000" +
                    "\u01d61\u0001\u0000\u0000\u0000\u01d7\u01d8\u0005\u0004\u0000\u0000\u01d8" +
                    "\u01e0\u0005\n\u0000\u0000\u01d9\u01df\u0003F#\u0000\u01da\u01df\u0003" +
                    "`0\u0000\u01db\u01df\u0003\u0084B\u0000\u01dc\u01df\u00036\u001b\u0000" +
                    "\u01dd\u01df\u00038\u001c\u0000\u01de\u01d9\u0001\u0000\u0000\u0000\u01de" +
                    "\u01da\u0001\u0000\u0000\u0000\u01de\u01db\u0001\u0000\u0000\u0000\u01de" +
                    "\u01dc\u0001\u0000\u0000\u0000\u01de\u01dd\u0001\u0000\u0000\u0000\u01df" +
                    "\u01e2\u0001\u0000\u0000\u0000\u01e0\u01de\u0001\u0000\u0000\u0000\u01e0" +
                    "\u01e1\u0001\u0000\u0000\u0000\u01e1\u01e3\u0001\u0000\u0000\u0000\u01e2" +
                    "\u01e0\u0001\u0000\u0000\u0000\u01e3\u01e4\u0005\u000b\u0000\u0000\u01e4" +
                    "3\u0001\u0000\u0000\u0000\u01e5\u01e6\u0005\u0005\u0000\u0000\u01e6\u01ee" +
                    "\u0005\n\u0000\u0000\u01e7\u01ed\u0003F#\u0000\u01e8\u01ed\u0003`0\u0000" +
                    "\u01e9\u01ed\u0003\u0084B\u0000\u01ea\u01ed\u00036\u001b\u0000\u01eb\u01ed" +
                    "\u00038\u001c\u0000\u01ec\u01e7\u0001\u0000\u0000\u0000\u01ec\u01e8\u0001" +
                    "\u0000\u0000\u0000\u01ec\u01e9\u0001\u0000\u0000\u0000\u01ec\u01ea\u0001" +
                    "\u0000\u0000\u0000\u01ec\u01eb\u0001\u0000\u0000\u0000\u01ed\u01f0\u0001" +
                    "\u0000\u0000\u0000\u01ee\u01ec\u0001\u0000\u0000\u0000\u01ee\u01ef\u0001" +
                    "\u0000\u0000\u0000\u01ef\u01f1\u0001\u0000\u0000\u0000\u01f0\u01ee\u0001" +
                    "\u0000\u0000\u0000\u01f1\u01f2\u0005\u000b\u0000\u0000\u01f25\u0001\u0000" +
                    "\u0000\u0000\u01f3\u01f4\u0005I\u0000\u0000\u01f4\u01f7\u0005\n\u0000" +
                    "\u0000\u01f5\u01f8\u0003(\u0014\u0000\u01f6\u01f8\u0003&\u0013\u0000\u01f7" +
                    "\u01f5\u0001\u0000\u0000\u0000\u01f7\u01f6\u0001\u0000\u0000\u0000\u01f8" +
                    "\u01f9\u0001\u0000\u0000\u0000\u01f9\u01fa\u0005\u000b\u0000\u0000\u01fa" +
                    "7\u0001\u0000\u0000\u0000\u01fb\u01fc\u0005J\u0000\u0000\u01fc\u01fd\u0005" +
                    "\u000c\u0000\u0000\u01fd\u01fe\u0005\u0095\u0000\u0000\u01fe\u01ff\u0005\r" +
                    "\u0000\u0000\u01ff\u0202\u0005\n\u0000\u0000\u0200\u0203\u0003(\u0014" +
                    "\u0000\u0201\u0203\u0003&\u0013\u0000\u0202\u0200\u0001\u0000\u0000\u0000" +
                    "\u0202\u0201\u0001\u0000\u0000\u0000\u0203\u0204\u0001\u0000\u0000\u0000" +
                    "\u0204\u0205\u0005\u000b\u0000\u0000\u02059\u0001\u0000\u0000\u0000\u0206" +
                    "\u0209\u0003<\u001e\u0000\u0207\u0209\u0003B!\u0000\u0208\u0206\u0001" +
                    "\u0000\u0000\u0000\u0208\u0207\u0001\u0000\u0000\u0000\u0209;\u0001\u0000" +
                    "\u0000\u0000\u020a\u020b\u0005A\u0000\u0000\u020b\u020c\u0005\u000c\u0000" +
                    "\u0000\u020c\u020d\u0003>\u001f\u0000\u020d\u020e\u0005Y\u0000\u0000\u020e" +
                    "\u020f\u0003D\"\u0000\u020f\u0210\u0005\r\u0000\u0000\u0210=\u0001\u0000" +
                    "\u0000\u0000\u0211\u0214\u0003@ \u0000\u0212\u0213\u0007\u0000\u0000\u0000" +
                    "\u0213\u0215\u0003B!\u0000\u0214\u0212\u0001\u0000\u0000\u0000\u0214\u0215" +
                    "\u0001\u0000\u0000\u0000\u0215?\u0001\u0000\u0000\u0000\u0216\u0217\u0007" +
                    "\u0001\u0000\u0000\u0217A\u0001\u0000\u0000\u0000\u0218\u021e\u0005\u0095" +
                    "\u0000\u0000\u0219\u021a\u0005\u0095\u0000\u0000\u021a\u021b\u0005\u000e" +
                    "\u0000\u0000\u021b\u021c\u0007\u0002\u0000\u0000\u021c\u021e\u0005\u000f" +
                    "\u0000\u0000\u021d\u0218\u0001\u0000\u0000\u0000\u021d\u0219\u0001\u0000" +
                    "\u0000\u0000\u021eC\u0001\u0000\u0000\u0000\u021f\u0222\u0003@ \u0000" +
                    "\u0220\u0222\u0003B!\u0000\u0221\u021f\u0001\u0000\u0000\u0000\u0221\u0220" +
                    "\u0001\u0000\u0000\u0000\u0222\u0228\u0001\u0000\u0000\u0000\u0223\u0226" +
                    "\u0005Y\u0000\u0000\u0224\u0227\u0003@ \u0000\u0225\u0227\u0003B!\u0000" +
                    "\u0226\u0224\u0001\u0000\u0000\u0000\u0226\u0225\u0001\u0000\u0000\u0000" +
                    "\u0227\u0229\u0001\u0000\u0000\u0000\u0228\u0223\u0001\u0000\u0000\u0000" +
                    "\u0228\u0229\u0001\u0000\u0000\u0000\u0229E\u0001\u0000\u0000\u0000\u022a" +
                    "\u0230\u0003H$\u0000\u022b\u0230\u0003J%\u0000\u022c\u0230\u0003L&\u0000" +
                    "\u022d\u0230\u0003N\'\u0000\u022e\u0230\u0003T*\u0000\u022f\u022a\u0001" +
                    "\u0000\u0000\u0000\u022f\u022b\u0001\u0000\u0000\u0000\u022f\u022c\u0001" +
                    "\u0000\u0000\u0000\u022f\u022d\u0001\u0000\u0000\u0000\u022f\u022e\u0001" +
                    "\u0000\u0000\u0000\u0230G\u0001\u0000\u0000\u0000\u0231\u0232\u0005\u0012" +
                    "\u0000\u0000\u0232\u0233\u0005\n\u0000\u0000\u0233\u0234\u0003Z-\u0000" +
                    "\u0234\u0235\u0005\u000b\u0000\u0000\u0235I\u0001\u0000\u0000\u0000\u0236" +
                    "\u0237\u0005\u0013\u0000\u0000\u0237\u0238\u0005\n\u0000\u0000\u0238\u0239" +
                    "\u0003Z-\u0000\u0239\u023a\u0005\u000b\u0000\u0000\u023aK\u0001\u0000" +
                    "\u0000\u0000\u023b\u023c\u0005\u0014\u0000\u0000\u023c\u023f\u0005\n\u0000" +
                    "\u0000\u023d\u0240\u0005\u0092\u0000\u0000\u023e\u0240\u0003:\u001d\u0000" +
                    "\u023f\u023d\u0001\u0000\u0000\u0000\u023f\u023e\u0001\u0000\u0000\u0000" +
                    "\u0240\u0241\u0001\u0000\u0000\u0000\u0241\u0242\u0005\u000b\u0000\u0000" +
                    "\u0242M\u0001\u0000\u0000\u0000\u0243\u0244\u0005\u0015\u0000\u0000\u0244" +
                    "\u0245\u0005\n\u0000\u0000\u0245\u0246\u0003P(\u0000\u0246\u0247\u0005" +
                    "\u000b\u0000\u0000\u0247O\u0001\u0000\u0000\u0000\u0248\u024e\u0003R)" +
                    "\u0000\u0249\u024a\u0003R)\u0000\u024a\u024b\u0005^\u0000\u0000\u024b" +
                    "\u024c\u0003P(\u0000\u024c\u024e\u0001\u0000\u0000\u0000\u024d\u0248\u0001" +
                    "\u0000\u0000\u0000\u024d\u0249\u0001\u0000\u0000\u0000\u024eQ\u0001\u0000" +
                    "\u0000\u0000\u024f\u0250\u0007\u0003\u0000\u0000\u0250S\u0001\u0000\u0000" +
                    "\u0000\u0251\u0252\u0005\u0016\u0000\u0000\u0252\u0256\u0005\n\u0000\u0000" +
                    "\u0253\u0255\u0003V+\u0000\u0254\u0253\u0001\u0000\u0000\u0000\u0255\u0258" +
                    "\u0001\u0000\u0000\u0000\u0256\u0254\u0001\u0000\u0000\u0000\u0256\u0257" +
                    "\u0001\u0000\u0000\u0000\u0257\u0259\u0001\u0000\u0000\u0000\u0258\u0256" +
                    "\u0001\u0000\u0000\u0000\u0259\u025a\u0005\u000b\u0000\u0000\u025aU\u0001" +
                    "\u0000\u0000\u0000\u025b\u025c\u0003X,\u0000\u025c\u025d\u0005\n\u0000" +
                    "\u0000\u025d\u025e\u0003^/\u0000\u025e\u025f\u0005\u000b\u0000\u0000\u025f" +
                    "W\u0001\u0000\u0000\u0000\u0260\u0261\u0007\u0004\u0000\u0000\u0261Y\u0001" +
                    "\u0000\u0000\u0000\u0262\u0265\u0003\\.\u0000\u0263\u0265\u0003^/\u0000" +
                    "\u0264\u0262\u0001\u0000\u0000\u0000\u0264\u0263\u0001\u0000\u0000\u0000" +
                    "\u0265[\u0001\u0000\u0000\u0000\u0266\u0267\u0007\u0005\u0000\u0000\u0267" +
                    "]\u0001\u0000\u0000\u0000\u0268\u0269\u0007\u0006\u0000\u0000\u0269\u026a" +
                    "\u0005X\u0000\u0000\u026a\u026b\u0007\u0007\u0000\u0000\u026b_\u0001\u0000" +
                    "\u0000\u0000\u026c\u0273\u0003b1\u0000\u026d\u0273\u0003d2\u0000\u026e" +
                    "\u0273\u0003f3\u0000\u026f\u0273\u0003h4\u0000\u0270\u0273\u0003\u0080" +
                    "@\u0000\u0271\u0273\u0003\u0082A\u0000\u0272\u026c\u0001\u0000\u0000\u0000" +
                    "\u0272\u026d\u0001\u0000\u0000\u0000\u0272\u026e\u0001\u0000\u0000\u0000" +
                    "\u0272\u026f\u0001\u0000\u0000\u0000\u0272\u0270\u0001\u0000\u0000\u0000" +
                    "\u0272\u0271\u0001\u0000\u0000\u0000\u0273a\u0001\u0000\u0000\u0000\u0274" +
                    "\u0275\u0005\u0017\u0000\u0000\u0275\u0278\u0005\n\u0000\u0000\u0276\u0279" +
                    "\u0005\u008e\u0000\u0000\u0277\u0279\u0003:\u001d\u0000\u0278\u0276\u0001" +
                    "\u0000\u0000\u0000\u0278\u0277\u0001\u0000\u0000\u0000\u0279\u027a\u0001" +
                    "\u0000\u0000\u0000\u027a\u027b\u0005\u000b\u0000\u0000\u027bc\u0001\u0000" +
                    "\u0000\u0000\u027c\u027d\u0005\u0018\u0000\u0000\u027d\u0280\u0005\n\u0000" +
                    "\u0000\u027e\u0281\u0005\u0092\u0000\u0000\u027f\u0281\u0003:\u001d\u0000" +
                    "\u0280\u027e\u0001\u0000\u0000\u0000\u0280\u027f\u0001\u0000\u0000\u0000" +
                    "\u0281\u0282\u0001\u0000\u0000\u0000\u0282\u0283\u0005\u000b\u0000\u0000" +
                    "\u0283e\u0001\u0000\u0000\u0000\u0284\u0285\u0005\u0019\u0000\u0000\u0285" +
                    "\u0289\u0005\n\u0000\u0000\u0286\u0288\u0003V+\u0000\u0287\u0286\u0001" +
                    "\u0000\u0000\u0000\u0288\u028b\u0001\u0000\u0000\u0000\u0289\u0287\u0001" +
                    "\u0000\u0000\u0000\u0289\u028a\u0001\u0000\u0000\u0000\u028a\u028c\u0001" +
                    "\u0000\u0000\u0000\u028b\u0289\u0001\u0000\u0000\u0000\u028c\u028d\u0005" +
                    "\u000b\u0000\u0000\u028dg\u0001\u0000\u0000\u0000\u028e\u028f\u0005\u001a" +
                    "\u0000\u0000\u028f\u0293\u0005\n\u0000\u0000\u0290\u0292\u0003j5\u0000" +
                    "\u0291\u0290\u0001\u0000\u0000\u0000\u0292\u0295\u0001\u0000\u0000\u0000" +
                    "\u0293\u0291\u0001\u0000\u0000\u0000\u0293\u0294\u0001\u0000\u0000\u0000" +
                    "\u0294\u0296\u0001\u0000\u0000\u0000\u0295\u0293\u0001\u0000\u0000\u0000" +
                    "\u0296\u0297\u0005\u000b\u0000\u0000\u0297i\u0001\u0000\u0000\u0000\u0298" +
                    "\u029c\u0003l6\u0000\u0299\u029c\u0003v;\u0000\u029a\u029c\u0003|>\u0000" +
                    "\u029b\u0298\u0001\u0000\u0000\u0000\u029b\u0299\u0001\u0000\u0000\u0000" +
                    "\u029b\u029a\u0001\u0000\u0000\u0000\u029ck\u0001\u0000\u0000\u0000\u029d" +
                    "\u029e\u0005\u001d\u0000\u0000\u029e\u02a2\u0005\n\u0000\u0000\u029f\u02a1" +
                    "\u0003n7\u0000\u02a0\u029f\u0001\u0000\u0000\u0000\u02a1\u02a4\u0001\u0000" +
                    "\u0000\u0000\u02a2\u02a0\u0001\u0000\u0000\u0000\u02a2\u02a3\u0001\u0000" +
                    "\u0000\u0000\u02a3\u02a5\u0001\u0000\u0000\u0000\u02a4\u02a2\u0001\u0000" +
                    "\u0000\u0000\u02a5\u02a6\u0005\u000b\u0000\u0000\u02a6m\u0001\u0000\u0000" +
                    "\u0000\u02a7\u02ac\u0003p8\u0000\u02a8\u02ac\u0003|>\u0000\u02a9\u02ac" +
                    "\u0003r9\u0000\u02aa\u02ac\u0003t:\u0000\u02ab\u02a7\u0001\u0000\u0000" +
                    "\u0000\u02ab\u02a8\u0001\u0000\u0000\u0000\u02ab\u02a9\u0001\u0000\u0000" +
                    "\u0000\u02ab\u02aa\u0001\u0000\u0000\u0000\u02aco\u0001\u0000\u0000\u0000" +
                    "\u02ad\u02ae\u0005\u0012\u0000\u0000\u02ae\u02af\u0005\n\u0000\u0000\u02af" +
                    "\u02b0\u0003^/\u0000\u02b0\u02b1\u0005\u000b\u0000\u0000\u02b1q\u0001" +
                    "\u0000\u0000\u0000\u02b2\u02b3\u0005 \u0000\u0000\u02b3\u02b4\u0005\n" +
                    "\u0000\u0000\u02b4\u02b5\u0003^/\u0000\u02b5\u02b6\u0005\u000b\u0000\u0000" +
                    "\u02b6s\u0001\u0000\u0000\u0000\u02b7\u02b8\u0005!\u0000\u0000\u02b8\u02b9" +
                    "\u0005\n\u0000\u0000\u02b9\u02ba\u0003^/\u0000\u02ba\u02bb\u0005\u000b" +
                    "\u0000\u0000\u02bbu\u0001\u0000\u0000\u0000\u02bc\u02bd\u0005\u001e\u0000" +
                    "\u0000\u02bd\u02c1\u0005\n\u0000\u0000\u02be\u02c0\u0003x<\u0000\u02bf" +
                    "\u02be\u0001\u0000\u0000\u0000\u02c0\u02c3\u0001\u0000\u0000\u0000\u02c1" +
                    "\u02bf\u0001\u0000\u0000\u0000\u02c1\u02c2\u0001\u0000\u0000\u0000\u02c2" +
                    "\u02c4\u0001\u0000\u0000\u0000\u02c3\u02c1\u0001\u0000\u0000\u0000\u02c4" +
                    "\u02c5\u0005\u000b\u0000\u0000\u02c5w\u0001\u0000\u0000\u0000\u02c6\u02c7" +
                    "\u0003z=\u0000\u02c7\u02c8\u0005\n\u0000\u0000\u02c8\u02c9\u0003^/\u0000" +
                    "\u02c9\u02ca\u0005\u000b\u0000\u0000\u02cay\u0001\u0000\u0000\u0000\u02cb" +
                    "\u02cc\u0007\b\u0000\u0000\u02cc{\u0001\u0000\u0000\u0000\u02cd\u02ce" +
                    "\u0005\u001f\u0000\u0000\u02ce\u02cf\u0005\n\u0000\u0000\u02cf\u02d0\u0003" +
                    "~?\u0000\u02d0\u02d1\u0005\u000b\u0000\u0000\u02d1}\u0001\u0000\u0000" +
                    "\u0000\u02d2\u02d3\u0005\u001f\u0000\u0000\u02d3\u02d6\u0005\u000c\u0000\u0000" +
                    "\u02d4\u02d7\u0005\u008c\u0000\u0000\u02d5\u02d7\u0003:\u001d\u0000\u02d6" +
                    "\u02d4\u0001\u0000\u0000\u0000\u02d6\u02d5\u0001\u0000\u0000\u0000\u02d7" +
                    "\u02d8\u0001\u0000\u0000\u0000\u02d8\u02d9\u0005\r\u0000\u0000\u02d9\u007f" +
                    "\u0001\u0000\u0000\u0000\u02da\u02db\u0005\u001b\u0000\u0000\u02db\u02de" +
                    "\u0005\n\u0000\u0000\u02dc\u02df\u0005\u0090\u0000\u0000\u02dd\u02df\u0003" +
                    ":\u001d\u0000\u02de\u02dc\u0001\u0000\u0000\u0000\u02de\u02dd\u0001\u0000" +
                    "\u0000\u0000\u02df\u02e0\u0001\u0000\u0000\u0000\u02e0\u02e1\u0005\u000b" +
                    "\u0000\u0000\u02e1\u0081\u0001\u0000\u0000\u0000\u02e2\u02e3\u0005\u001c" +
                    "\u0000\u0000\u02e3\u02e6\u0005\n\u0000\u0000\u02e4\u02e7\u0005\u0090\u0000" +
                    "\u0000\u02e5\u02e7\u0003:\u001d\u0000\u02e6\u02e4\u0001\u0000\u0000\u0000" +
                    "\u02e6\u02e5\u0001\u0000\u0000\u0000\u02e7\u02e8\u0001\u0000\u0000\u0000" +
                    "\u02e8\u02e9\u0005\u000b\u0000\u0000\u02e9\u0083\u0001\u0000\u0000\u0000" +
                    "\u02ea\u02ee\u0003\u0086C\u0000\u02eb\u02ee\u0003\u0088D\u0000\u02ec\u02ee" +
                    "\u0003\u008aE\u0000\u02ed\u02ea\u0001\u0000\u0000\u0000\u02ed\u02eb\u0001" +
                    "\u0000\u0000\u0000\u02ed\u02ec\u0001\u0000\u0000\u0000\u02ee\u0085\u0001" +
                    "\u0000\u0000\u0000\u02ef\u02f0\u0005K\u0000\u0000\u02f0\u02f2\u0005\n" +
                    "\u0000\u0000\u02f1\u02f3\u0003\u008cF\u0000\u02f2\u02f1\u0001\u0000\u0000" +
                    "\u0000\u02f3\u02f4\u0001\u0000\u0000\u0000\u02f4\u02f2\u0001\u0000\u0000" +
                    "\u0000\u02f4\u02f5\u0001\u0000\u0000\u0000\u02f5\u02f6\u0001\u0000\u0000" +
                    "\u0000\u02f6\u02f7\u0005\u000b\u0000\u0000\u02f7\u0087\u0001\u0000\u0000" +
                    "\u0000\u02f8\u02f9\u0005L\u0000\u0000\u02f9\u02fb\u0005\n\u0000\u0000" +
                    "\u02fa\u02fc\u0003\u008cF\u0000\u02fb\u02fa\u0001\u0000\u0000\u0000\u02fc" +
                    "\u02fd\u0001\u0000\u0000\u0000\u02fd\u02fb\u0001\u0000\u0000\u0000\u02fd" +
                    "\u02fe\u0001\u0000\u0000\u0000\u02fe\u02ff\u0001\u0000\u0000\u0000\u02ff" +
                    "\u0300\u0005\u000b\u0000\u0000\u0300\u0089\u0001\u0000\u0000\u0000\u0301" +
                    "\u0302\u0005M\u0000\u0000\u0302\u0304\u0005\n\u0000\u0000\u0303\u0305" +
                    "\u0003\u008cF\u0000\u0304\u0303\u0001\u0000\u0000\u0000\u0305\u0306\u0001" +
                    "\u0000\u0000\u0000\u0306\u0304\u0001\u0000\u0000\u0000\u0306\u0307\u0001" +
                    "\u0000\u0000\u0000\u0307\u0308\u0001\u0000\u0000\u0000\u0308\u0309\u0005" +
                    "\u000b\u0000\u0000\u0309\u008b\u0001\u0000\u0000\u0000\u030a\u030b\u0005" +
                    "\u0095\u0000\u0000\u030b\u0311\u0005`\u0000\u0000\u030c\u0312\u0003<\u001e" +
                    "\u0000\u030d\u0312\u0003\u008eG\u0000\u030e\u0312\u0003\u0090H\u0000\u030f" +
                    "\u0312\u0003@ \u0000\u0310\u0312\u0003B!\u0000\u0311\u030c\u0001\u0000" +
                    "\u0000\u0000\u0311\u030d\u0001\u0000\u0000\u0000\u0311\u030e\u0001\u0000" +
                    "\u0000\u0000\u0311\u030f\u0001\u0000\u0000\u0000\u0311\u0310\u0001\u0000" +
                    "\u0000\u0000\u0312\u008d\u0001\u0000\u0000\u0000\u0313\u0314\u0005\u0095" +
                    "\u0000\u0000\u0314\u0315\u0005X\u0000\u0000\u0315\u0316\u0005@\u0000\u0000" +
                    "\u0316\u0317\u0005\n\u0000\u0000\u0317\u0318\u0003\u0092I\u0000\u0318" +
                    "\u0319\u0005c\u0000\u0000\u0319\u031a\u0003>\u001f\u0000\u031a\u031e\u0005" +
                    "\u000b\u0000\u0000\u031b\u031c\u0005\u000e\u0000\u0000\u031c\u031d\u0007" +
                    "\u0002\u0000\u0000\u031d\u031f\u0005\u000f\u0000\u0000\u031e\u031b\u0001" +
                    "\u0000\u0000\u0000\u031e\u031f\u0001\u0000\u0000\u0000\u031f\u008f\u0001" +
                    "\u0000\u0000\u0000\u0320\u0321\u0005\u0095\u0000\u0000\u0321\u0322\u0005" +
                    "X\u0000\u0000\u0322\u0323\u0005B\u0000\u0000\u0323\u0324\u0005\n\u0000" +
                    "\u0000\u0324\u0325\u0003\u0092I\u0000\u0325\u0326\u0005c\u0000\u0000\u0326" +
                    "\u0327\u0003>\u001f\u0000\u0327\u032b\u0005\u000b\u0000\u0000\u0328\u0329" +
                    "\u0005\u000e\u0000\u0000\u0329\u032a\u0007\u0002\u0000\u0000\u032a\u032c" +
                    "\u0005\u000f\u0000\u0000\u032b\u0328\u0001\u0000\u0000\u0000\u032b\u032c" +
                    "\u0001\u0000\u0000\u0000\u032c\u0091\u0001\u0000\u0000\u0000\u032d\u0332" +
                    "\u0005\u0095\u0000\u0000\u032e\u032f\u0005\u0095\u0000\u0000\u032f\u0330" +
                    "\u0005Y\u0000\u0000\u0330\u0332\u0005\u0095\u0000\u0000\u0331\u032d\u0001" +
                    "\u0000\u0000\u0000\u0331\u032e\u0001\u0000\u0000\u0000\u0332\u0093\u0001" +
                    "\u0000\u0000\u0000\u0333\u0337\u0003\u0096K\u0000\u0334\u0337\u0003\u0098" +
                    "L\u0000\u0335\u0337\u0003\u009aM\u0000\u0336\u0333\u0001\u0000\u0000\u0000" +
                    "\u0336\u0334\u0001\u0000\u0000\u0000\u0336\u0335\u0001\u0000\u0000\u0000" +
                    "\u0337\u0095\u0001\u0000\u0000\u0000\u0338\u0339\u0005;\u0000\u0000\u0339" +
                    "\u033c\u0005\n\u0000\u0000\u033a\u033d\u0005\u0094\u0000\u0000\u033b\u033d" +
                    "\u0003:\u001d\u0000\u033c\u033a\u0001\u0000\u0000\u0000\u033c\u033b\u0001" +
                    "\u0000\u0000\u0000\u033d\u033e\u0001\u0000\u0000\u0000\u033e\u033f\u0005" +
                    "\u000b\u0000\u0000\u033f\u0097\u0001\u0000\u0000\u0000\u0340\u0341\u0005" +
                    "<\u0000\u0000\u0341\u0342\u0005\n\u0000\u0000\u0342\u0343\u0003^/\u0000" +
                    "\u0343\u0344\u0005\u000b\u0000\u0000\u0344\u0099\u0001\u0000\u0000\u0000" +
                    "\u0345\u0346\u0005=\u0000\u0000\u0346\u0347\u0005\n\u0000\u0000\u0347" +
                    "\u0348\u0003^/\u0000\u0348\u0349\u0005\u000b\u0000\u0000\u0349\u009b\u0001" +
                    "\u0000\u0000\u0000\u034a\u034b\u0005\u0007\u0000\u0000\u034b\u0352\u0005" +
                    "\n\u0000\u0000\u034c\u0351\u0003`0\u0000\u034d\u0351\u0003F#\u0000\u034e" +
                    "\u0351\u0003\u0084B\u0000\u034f\u0351\u0003\u009eO\u0000\u0350\u034c\u0001" +
                    "\u0000\u0000\u0000\u0350\u034d\u0001\u0000\u0000\u0000\u0350\u034e\u0001" +
                    "\u0000\u0000\u0000\u0350\u034f\u0001\u0000\u0000\u0000\u0351\u0354\u0001" +
                    "\u0000\u0000\u0000\u0352\u0350\u0001\u0000\u0000\u0000\u0352\u0353\u0001" +
                    "\u0000\u0000\u0000\u0353\u0355\u0001\u0000\u0000\u0000\u0354\u0352\u0001" +
                    "\u0000\u0000\u0000\u0355\u0356\u0005\u000b\u0000\u0000\u0356\u009d\u0001" +
                    "\u0000\u0000\u0000\u0357\u035f\u0003\u00a0P\u0000\u0358\u035f\u0003\u00a2" +
                    "Q\u0000\u0359\u035f\u0003\u00b0X\u0000\u035a\u035f\u0003\u00b4Z\u0000" +
                    "\u035b\u035f\u0003\u00b8\\\u0000\u035c\u035f\u0003\u00ba]\u0000\u035d" +
                    "\u035f\u0003\u00bc^\u0000\u035e\u0357\u0001\u0000\u0000\u0000\u035e\u0358" +
                    "\u0001\u0000\u0000\u0000\u035e\u0359\u0001\u0000\u0000\u0000\u035e\u035a" +
                    "\u0001\u0000\u0000\u0000\u035e\u035b\u0001\u0000\u0000\u0000\u035e\u035c" +
                    "\u0001\u0000\u0000\u0000\u035e\u035d\u0001\u0000\u0000\u0000\u035f\u009f" +
                    "\u0001\u0000\u0000\u0000\u0360\u0361\u0005\"\u0000\u0000\u0361\u0364\u0005" +
                    "\n\u0000\u0000\u0362\u0365\u0005\u008e\u0000\u0000\u0363\u0365\u0003:" +
                    "\u001d\u0000\u0364\u0362\u0001\u0000\u0000\u0000\u0364\u0363\u0001\u0000" +
                    "\u0000\u0000\u0365\u0366\u0001\u0000\u0000\u0000\u0366\u0367\u0005\u000b" +
                    "\u0000\u0000\u0367\u00a1\u0001\u0000\u0000\u0000\u0368\u0369\u0005$\u0000" +
                    "\u0000\u0369\u036d\u0005\n\u0000\u0000\u036a\u036c\u0003\u00a4R\u0000" +
                    "\u036b\u036a\u0001\u0000\u0000\u0000\u036c\u036f\u0001\u0000\u0000\u0000" +
                    "\u036d\u036b\u0001\u0000\u0000\u0000\u036d\u036e\u0001\u0000\u0000\u0000" +
                    "\u036e\u0370\u0001\u0000\u0000\u0000\u036f\u036d\u0001\u0000\u0000\u0000" +
                    "\u0370\u0371\u0005\u000b\u0000\u0000\u0371\u00a3\u0001\u0000\u0000\u0000" +
                    "\u0372\u0378\u0003|>\u0000\u0373\u0378\u0003\u00a6S\u0000\u0374\u0378" +
                    "\u0003\u00a8T\u0000\u0375\u0378\u0003\u00acV\u0000\u0376\u0378\u0003\u00ae" +
                    "W\u0000\u0377\u0372\u0001\u0000\u0000\u0000\u0377\u0373\u0001\u0000\u0000" +
                    "\u0000\u0377\u0374\u0001\u0000\u0000\u0000\u0377\u0375\u0001\u0000\u0000" +
                    "\u0000\u0377\u0376\u0001\u0000\u0000\u0000\u0378\u00a5\u0001\u0000\u0000" +
                    "\u0000\u0379\u037a\u0005%\u0000\u0000\u037a\u037b\u0005\n\u0000\u0000" +
                    "\u037b\u037c\u0003^/\u0000\u037c\u037d\u0005\u000b\u0000\u0000\u037d\u00a7" +
                    "\u0001\u0000\u0000\u0000\u037e\u037f\u0005&\u0000\u0000\u037f\u0380\u0005" +
                    "\n\u0000\u0000\u0380\u0381\u0003\u00aaU\u0000\u0381\u0382\u0005\u000b" +
                    "\u0000\u0000\u0382\u00a9\u0001\u0000\u0000\u0000\u0383\u0384\u0007\t\u0000" +
                    "\u0000\u0384\u00ab\u0001\u0000\u0000\u0000\u0385\u0386\u0005\'\u0000\u0000" +
                    "\u0386\u0389\u0005\n\u0000\u0000\u0387\u038a\u0005\u0090\u0000\u0000\u0388" +
                    "\u038a\u0003:\u001d\u0000\u0389\u0387\u0001\u0000\u0000\u0000\u0389\u0388" +
                    "\u0001\u0000\u0000\u0000\u038a\u038b\u0001\u0000\u0000\u0000\u038b\u038c" +
                    "\u0005\u000b\u0000\u0000\u038c\u00ad\u0001\u0000\u0000\u0000\u038d\u038e" +
                    "\u0005(\u0000\u0000\u038e\u0391\u0005\n\u0000\u0000\u038f\u0392\u0005" +
                    "\u0090\u0000\u0000\u0390\u0392\u0003:\u001d\u0000\u0391\u038f\u0001\u0000" +
                    "\u0000\u0000\u0391\u0390\u0001\u0000\u0000\u0000\u0392\u0393\u0001\u0000" +
                    "\u0000\u0000\u0393\u0394\u0005\u000b\u0000\u0000\u0394\u00af\u0001\u0000" +
                    "\u0000\u0000\u0395\u0396\u0005)\u0000\u0000\u0396\u0397\u0005\n\u0000" +
                    "\u0000\u0397\u0398\u0003\u00b2Y\u0000\u0398\u0399\u0005\u000b\u0000\u0000" +
                    "\u0399\u00b1\u0001\u0000\u0000\u0000\u039a\u039b\u0007\n\u0000\u0000\u039b" +
                    "\u00b3\u0001\u0000\u0000\u0000\u039c\u039d\u0005*\u0000\u0000\u039d\u039e" +
                    "\u0005\n\u0000\u0000\u039e\u039f\u0003\u00b6[\u0000\u039f\u03a0\u0005" +
                    "\u000b\u0000\u0000\u03a0\u00b5\u0001\u0000\u0000\u0000\u03a1\u03a2\u0007" +
                    "\u000b\u0000\u0000\u03a2\u00b7\u0001\u0000\u0000\u0000\u03a3\u03a4\u0005" +
                    "+\u0000\u0000\u03a4\u03a7\u0005\n\u0000\u0000\u03a5\u03a8\u0005\u0094" +
                    "\u0000\u0000\u03a6\u03a8\u0003:\u001d\u0000\u03a7\u03a5\u0001\u0000\u0000" +
                    "\u0000\u03a7\u03a6\u0001\u0000\u0000\u0000\u03a8\u03a9\u0001\u0000\u0000" +
                    "\u0000\u03a9\u03aa\u0005\u000b\u0000\u0000\u03aa\u00b9\u0001\u0000\u0000" +
                    "\u0000\u03ab\u03ac\u0005,\u0000\u0000\u03ac\u03ad\u0005\n\u0000\u0000" +
                    "\u03ad\u03ae\u0003^/\u0000\u03ae\u03af\u0005\u000b\u0000\u0000\u03af\u00bb" +
                    "\u0001\u0000\u0000\u0000\u03b0\u03b1\u0005-\u0000\u0000\u03b1\u03b2\u0005" +
                    "\n\u0000\u0000\u03b2\u03b3\u0003^/\u0000\u03b3\u03b4\u0005\u000b\u0000" +
                    "\u0000\u03b4\u00bd\u0001\u0000\u0000\u0000\u03b5\u03b6\u0005\t\u0000\u0000" +
                    "\u03b6\u03bd\u0005\n\u0000\u0000\u03b7\u03bc\u0003\u00c0`\u0000\u03b8" +
                    "\u03bc\u0003F#\u0000\u03b9\u03bc\u0003\u0084B\u0000\u03ba\u03bc\u0003" +
                    "`0\u0000\u03bb\u03b7\u0001\u0000\u0000\u0000\u03bb\u03b8\u0001\u0000\u0000" +
                    "\u0000\u03bb\u03b9\u0001\u0000\u0000\u0000\u03bb\u03ba\u0001\u0000\u0000" +
                    "\u0000\u03bc\u03bf\u0001\u0000\u0000\u0000\u03bd\u03bb\u0001\u0000\u0000" +
                    "\u0000\u03bd\u03be\u0001\u0000\u0000\u0000\u03be\u03c0\u0001\u0000\u0000" +
                    "\u0000\u03bf\u03bd\u0001\u0000\u0000\u0000\u03c0\u03c1\u0005\u000b\u0000" +
                    "\u0000\u03c1\u00bf\u0001\u0000\u0000\u0000\u03c2\u03c9\u0003\u00c2a\u0000" +
                    "\u03c3\u03c9\u0003\u00c4b\u0000\u03c4\u03c9\u0003\u00c6c\u0000\u03c5\u03c9" +
                    "\u0003\u00c8d\u0000\u03c6\u03c9\u0003\u00cae\u0000\u03c7\u03c9\u0003\u00ce" +
                    "g\u0000\u03c8\u03c2\u0001\u0000\u0000\u0000\u03c8\u03c3\u0001\u0000\u0000" +
                    "\u0000\u03c8\u03c4\u0001\u0000\u0000\u0000\u03c8\u03c5\u0001\u0000\u0000" +
                    "\u0000\u03c8\u03c6\u0001\u0000\u0000\u0000\u03c8\u03c7\u0001\u0000\u0000" +
                    "\u0000\u03c9\u00c1\u0001\u0000\u0000\u0000\u03ca\u03cb\u00055\u0000\u0000" +
                    "\u03cb\u03ce\u0005\n\u0000\u0000\u03cc\u03cf\u0005\u008e\u0000\u0000\u03cd" +
                    "\u03cf\u0003:\u001d\u0000\u03ce\u03cc\u0001\u0000\u0000\u0000\u03ce\u03cd" +
                    "\u0001\u0000\u0000\u0000\u03cf\u03d0\u0001\u0000\u0000\u0000\u03d0\u03d1" +
                    "\u0005\u000b\u0000\u0000\u03d1\u00c3\u0001\u0000\u0000\u0000\u03d2\u03d3" +
                    "\u00056\u0000\u0000\u03d3\u03d4\u0005\n\u0000\u0000\u03d4\u03d5\u0003" +
                    "~?\u0000\u03d5\u03d6\u0005\u000b\u0000\u0000\u03d6\u00c5\u0001\u0000\u0000" +
                    "\u0000\u03d7\u03d8\u00057\u0000\u0000\u03d8\u03d9\u0005\n\u0000\u0000" +
                    "\u03d9\u03da\u0003~?\u0000\u03da\u03db\u0005\u000b\u0000\u0000\u03db\u00c7" +
                    "\u0001\u0000\u0000\u0000\u03dc\u03dd\u00058\u0000\u0000\u03dd\u03de\u0005" +
                    "\n\u0000\u0000\u03de\u03df\u0003~?\u0000\u03df\u03e0\u0005\u000b\u0000" +
                    "\u0000\u03e0\u00c9\u0001\u0000\u0000\u0000\u03e1\u03e2\u00059\u0000\u0000" +
                    "\u03e2\u03e3\u0005\n\u0000\u0000\u03e3\u03e4\u0003\u00ccf\u0000\u03e4" +
                    "\u03e5\u0005\u000b\u0000\u0000\u03e5\u00cb\u0001\u0000\u0000\u0000\u03e6" +
                    "\u03e7\u0007\u000c\u0000\u0000\u03e7\u00cd\u0001\u0000\u0000\u0000\u03e8\u03e9" +
                    "\u0005:\u0000\u0000\u03e9\u03ea\u0005\n\u0000\u0000\u03ea\u03eb\u0003" +
                    "\u00d0h\u0000\u03eb\u03ec\u0005\u000b\u0000\u0000\u03ec\u00cf\u0001\u0000" +
                    "\u0000\u0000\u03ed\u03ee\u0007\r\u0000\u0000\u03ee\u00d1\u0001\u0000\u0000" +
                    "\u0000\u03ef\u03f0\u0005\b\u0000\u0000\u03f0\u03f7\u0005\n\u0000\u0000" +
                    "\u03f1\u03f6\u0003\u00d4j\u0000\u03f2\u03f6\u0003F#\u0000\u03f3\u03f6" +
                    "\u0003\u0084B\u0000\u03f4\u03f6\u0003`0\u0000\u03f5\u03f1\u0001\u0000" +
                    "\u0000\u0000\u03f5\u03f2\u0001\u0000\u0000\u0000\u03f5\u03f3\u0001\u0000" +
                    "\u0000\u0000\u03f5\u03f4\u0001\u0000\u0000\u0000\u03f6\u03f9\u0001\u0000" +
                    "\u0000\u0000\u03f7\u03f5\u0001\u0000\u0000\u0000\u03f7\u03f8\u0001\u0000" +
                    "\u0000\u0000\u03f8\u03fa\u0001\u0000\u0000\u0000\u03f9\u03f7\u0001\u0000" +
                    "\u0000\u0000\u03fa\u03fb\u0005\u000b\u0000\u0000\u03fb\u00d3\u0001\u0000" +
                    "\u0000\u0000\u03fc\u0403\u0003\u00a0P\u0000\u03fd\u0403\u0003\u00d6k\u0000" +
                    "\u03fe\u0403\u0003\u00ba]\u0000\u03ff\u0403\u0003\u00bc^\u0000\u0400\u0403" +
                    "\u0003\u00ecv\u0000\u0401\u0403\u0003\u00d8l\u0000\u0402\u03fc\u0001\u0000" +
                    "\u0000\u0000\u0402\u03fd\u0001\u0000\u0000\u0000\u0402\u03fe\u0001\u0000" +
                    "\u0000\u0000\u0402\u03ff\u0001\u0000\u0000\u0000\u0402\u0400\u0001\u0000" +
                    "\u0000\u0000\u0402\u0401\u0001\u0000\u0000\u0000\u0403\u00d5\u0001\u0000" +
                    "\u0000\u0000\u0404\u0405\u0005#\u0000\u0000\u0405\u0409\u0005\n\u0000" +
                    "\u0000\u0406\u0408\u0003\u00a4R\u0000\u0407\u0406\u0001\u0000\u0000\u0000" +
                    "\u0408\u040b\u0001\u0000\u0000\u0000\u0409\u0407\u0001\u0000\u0000\u0000" +
                    "\u0409\u040a\u0001\u0000\u0000\u0000\u040a\u040c\u0001\u0000\u0000\u0000" +
                    "\u040b\u0409\u0001\u0000\u0000\u0000\u040c\u040d\u0005\u000b\u0000\u0000" +
                    "\u040d\u00d7\u0001\u0000\u0000\u0000\u040e\u040f\u0005.\u0000\u0000\u040f" +
                    "\u0413\u0005\n\u0000\u0000\u0410\u0412\u0003\u00dam\u0000\u0411\u0410" +
                    "\u0001\u0000\u0000\u0000\u0412\u0415\u0001\u0000\u0000\u0000\u0413\u0411" +
                    "\u0001\u0000\u0000\u0000\u0413\u0414\u0001\u0000\u0000\u0000\u0414\u0416" +
                    "\u0001\u0000\u0000\u0000\u0415\u0413\u0001\u0000\u0000\u0000\u0416\u0417" +
                    "\u0005\u000b\u0000\u0000\u0417\u00d9\u0001\u0000\u0000\u0000\u0418\u041e" +
                    "\u0003\u00dcn\u0000\u0419\u041e\u0003\u00e0p\u0000\u041a\u041e\u0003\u00e2" +
                    "q\u0000\u041b\u041e\u0003\u00e6s\u0000\u041c\u041e\u0003\u00eau\u0000" +
                    "\u041d\u0418\u0001\u0000\u0000\u0000\u041d\u0419\u0001\u0000\u0000\u0000" +
                    "\u041d\u041a\u0001\u0000\u0000\u0000\u041d\u041b\u0001\u0000\u0000\u0000" +
                    "\u041d\u041c\u0001\u0000\u0000\u0000\u041e\u00db\u0001\u0000\u0000\u0000" +
                    "\u041f\u0420\u0005/\u0000\u0000\u0420\u0421\u0005\n\u0000\u0000\u0421" +
                    "\u0422\u0003\u00deo\u0000\u0422\u0423\u0005\u000b\u0000\u0000\u0423\u00dd" +
                    "\u0001\u0000\u0000\u0000\u0424\u0425\u0007\u000e\u0000\u0000\u0425\u00df" +
                    "\u0001\u0000\u0000\u0000\u0426\u0427\u00050\u0000\u0000\u0427\u042a\u0005" +
                    "\n\u0000\u0000\u0428\u042b\u0005\u0090\u0000\u0000\u0429\u042b\u0003:" +
                    "\u001d\u0000\u042a\u0428\u0001\u0000\u0000\u0000\u042a\u0429\u0001\u0000" +
                    "\u0000\u0000\u042b\u042c\u0001\u0000\u0000\u0000\u042c\u042d\u0005\u000b" +
                    "\u0000\u0000\u042d\u00e1\u0001\u0000\u0000\u0000\u042e\u042f\u00051\u0000" +
                    "\u0000\u042f\u0430\u0005\n\u0000\u0000\u0430\u0431\u0003\u00e4r\u0000" +
                    "\u0431\u0432\u0005\u000b\u0000\u0000\u0432\u00e3\u0001\u0000\u0000\u0000" +
                    "\u0433\u0434\u0007\u000f\u0000\u0000\u0434\u00e5\u0001\u0000\u0000\u0000" +
                    "\u0435\u0436\u00052\u0000\u0000\u0436\u0437\u0005\n\u0000\u0000\u0437" +
                    "\u0438\u0003\u00e8t\u0000\u0438\u0439\u0005\u000b\u0000\u0000\u0439\u00e7" +
                    "\u0001\u0000\u0000\u0000\u043a\u043b\u0007\u0010\u0000\u0000\u043b\u00e9" +
                    "\u0001\u0000\u0000\u0000\u043c\u043d\u00053\u0000\u0000\u043d\u043e\u0005" +
                    "\n\u0000\u0000\u043e\u043f\u0003\u00e8t\u0000\u043f\u0440\u0005\u000b" +
                    "\u0000\u0000\u0440\u00eb\u0001\u0000\u0000\u0000\u0441\u0442\u00054\u0000" +
                    "\u0000\u0442\u0445\u0005\n\u0000\u0000\u0443\u0446\u0005\u0090\u0000\u0000" +
                    "\u0444\u0446\u0003:\u001d\u0000\u0445\u0443\u0001\u0000\u0000\u0000\u0445" +
                    "\u0444\u0001\u0000\u0000\u0000\u0446\u0447\u0001\u0000\u0000\u0000\u0447" +
                    "\u0448\u0005\u000b\u0000\u0000\u0448\u00ed\u0001\u0000\u0000\u0000[\u00f1" +
                    "\u00f6\u0102\u0109\u010f\u0125\u0129\u012f\u0133\u0139\u013d\u0143\u0147" +
                    "\u015f\u0165\u016d\u0173\u017b\u0181\u0189\u018f\u0197\u019c\u01a5\u01a7" +
                    "\u01b3\u01b5\u01c1\u01c3\u01d0\u01d2\u01de\u01e0\u01ec\u01ee\u01f7\u0202" +
                    "\u0208\u0214\u021d\u0221\u0226\u0228\u022f\u023f\u024d\u0256\u0264\u0272" +
                    "\u0278\u0280\u0289\u0293\u029b\u02a2\u02ab\u02c1\u02d6\u02de\u02e6\u02ed" +
                    "\u02f4\u02fd\u0306\u0311\u031e\u032b\u0331\u0336\u033c\u0350\u0352\u035e" +
                    "\u0364\u036d\u0377\u0389\u0391\u03a7\u03bb\u03bd\u03c8\u03ce\u03f5\u03f7" +
                    "\u0402\u0409\u0413\u041d\u042a\u0445"
        val _ATN: ATN = ATNDeserializer().deserialize(_serializedATN.toCharArray())

        init {
            _decisionToDFA = arrayOfNulls(_ATN.numberOfDecisions)
            for (i in 0 until _ATN.numberOfDecisions) {
                _decisionToDFA[i] = DFA(_ATN.getDecisionState(i), i)
            }
        }
    }
}