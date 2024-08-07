package glsl.plugin.language

import com.intellij.lang.PsiBuilder
import com.intellij.psi.tree.IElementType
import glsl._GlslParser
import utils.GeneratedParserUtil

/**
 *
 */
class GlslParserAdapter : _GlslParser() {

    /**
     *
     */
    override fun parseLight(root: IElementType, originalBuilder: PsiBuilder) {
        val state = GeneratedParserUtil.ErrorState()
        GeneratedParserUtil.ErrorState.initState(state, originalBuilder, root.language, EXTENDS_SETS_)
        val builder = GlslPsiBuilder(originalBuilder, state, this)
        val marker = GeneratedParserUtil.enter_section_(builder, 0, GeneratedParserUtil._COLLAPSE_, null)
        val result = parse_root_(root, builder)
        GeneratedParserUtil.exit_section_(builder, 0, marker, root, result, true, GeneratedParserUtil.TRUE_CONDITION)
    }
}