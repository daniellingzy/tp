package vimification.logic.parser;

import vimification.commons.core.Index;
import vimification.logic.commands.DeleteCommand;

public class DeleteCommandParser implements LogicCommandParser<DeleteCommand> {

    private static final ApplicativeParser<Index> INDEX_PARSER =
            ApplicativeParser.parseNonWhitespaces().flatMap(indexStr -> {
                try {
                    int indexInt = Integer.parseInt(indexStr);
                    Index index = Index.fromOneBased(indexInt);
                    return ApplicativeParser.of(index);
                } catch (NumberFormatException ex) {
                    return ApplicativeParser.fail();
                }
            });

    private static final ApplicativeParser<DeleteCommand> DELETE_COMMAND_PARSER = ApplicativeParser
            .parseString("d")
            .takeNext(ApplicativeParser.skipWhitespaces())
            .takeNext(INDEX_PARSER)
            .dropNext(ApplicativeParser.skipWhitespaces())
            .dropNext(ApplicativeParser.eof())
            .map(DeleteCommand::new);

    public static DeleteCommandParser getInstance() {
        return new DeleteCommandParser();
    }

    @Override
    public ApplicativeParser<DeleteCommand> getParser() {
        return DELETE_COMMAND_PARSER;
    }
}
