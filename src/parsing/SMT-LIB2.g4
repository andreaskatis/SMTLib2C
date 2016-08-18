grammar SMTLIB;

program: (declare | body | check)* EOF;

declare: '(' 'declare-fun' ID '(' ')' type ')';

body: '(' 'assert' '(' letexp ')' ')';

check: '(check-sat)' -> skip;

letexp: 'let' '(' varDecl* ')' '(' letbody ')';

varDecl: '(' ID expr ')'

letbody: letexp;

type: 'Int'                                              # intType
    | 'Bool'                                             # boolType
    ;


lhs: eID (',' eID)*;

expr: ID                                                       # idExpr
    | INT                                                      # intExpr
    | REAL                                                     # realExpr
    | BOOL                                                     # boolExpr
    | op='(' ('to_real' | 'to_int') expr ')'                   # castExpr
    | 'not' expr                                               # notExpr
    | op=('*' | 'div' | 'mod') expr expr                       # binaryExpr
    | op=('+' | '-') expr expr                                 # binaryExpr
    | op=('<' | '<=' | '>' | '>=' | '=' ) expr expr            # binaryExpr
    | op='and' expr expr                                       # binaryExpr
    | op=('or' | 'xor') expr expr                              # binaryExpr
    | <assoc=right> op='=>' expr expr                          # binaryExpr
    | <assoc=right> op='->' expr expr                          # binaryExpr
    | 'ite' expr expr expr                                     # ifThenElseExpr
    | '(' expr ')'                                             # parenExpr
    ;


REAL: INT '.' INT;

BOOL: 'true' | 'false';
INT: [0-9]+;


ID: [a-zA-Z_$][a-zA-Z_0-9$]*;

WS: [ \t\n\r\f]+ -> skip;

SL_COMMENT: '//' (~[%\n\r] ~[\n\r]* | /* empty */) ('\r'? '\n')? -> skip;
ML_COMMENT: '(*' .*? '*)' -> skip;

ERROR: .;
