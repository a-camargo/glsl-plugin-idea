package glsl.plugin.language

import com.intellij.lang.ASTNode
import com.intellij.lang.Language
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType.WHITE_SPACE
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import glsl.GlslTypes.*


/**
 *
 */
class GlslLanguage : Language("Glsl") {
    companion object {
        val INSTANCE = GlslLanguage()
        val RIGHT_PAREN_MACRO_CALL = GlslTokenType("RIGHT_PAREN_MACRO_CALL")
        val LEFT_PAREN_MACRO_CALL = GlslTokenType("LEFT_PAREN_MACRO_CALL")
    }
}

/**
 *
 */
class GlslTokenType(debugName: String) : IElementType(debugName, GlslLanguage.INSTANCE)

/**
 *
 */
class GlslElementType(debugName: String) : IElementType(debugName, GlslLanguage.INSTANCE)


/**
 *
 */
class GlslParserDefinition : ParserDefinition {

    /**
     *
     */
    override fun createLexer(project: Project?): Lexer {
        return GlslLexer()
    }

    /**
     *
     */
    override fun createParser(project: Project?): PsiParser {
        return GlslParserAdapter()
    }

    /**
     *
     */
    override fun getFileNodeType(): IFileElementType {
        return IFileElementType(GlslLanguage.INSTANCE)
    }

    /**
     *
     */
    override fun getWhitespaceTokens(): TokenSet {
        return TokenSet.create(WHITE_SPACE)
    }

    /**
     *
     */
    override fun getCommentTokens(): TokenSet {
        return TokenSet.create(LINE_COMMENT, MULTILINE_COMMENT)
    }

    /**
     *
     */
    override fun getStringLiteralElements(): TokenSet {
        return TokenSet.create(STRING_LITERAL)
    }

    /**
     *
     */
    override fun createElement(node: ASTNode?): PsiElement {
        return Factory.createElement(node)
    }

    /**
     *
     */
    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return GlslFile(viewProvider)
    }
}
