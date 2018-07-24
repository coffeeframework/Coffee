/*
 * generated by Xtext 2.12.0
 */
package org.xtext.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.xtext.parser.antlr.internal.InternalPLhlclParser;
import org.xtext.services.PLhlclGrammarAccess;

public class PLhlclParser extends AbstractAntlrParser {

	@Inject
	private PLhlclGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalPLhlclParser createParser(XtextTokenStream stream) {
		return new InternalPLhlclParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "Model";
	}

	public PLhlclGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(PLhlclGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}