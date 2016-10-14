grammar SMTLIB2;

scratch: (skolem | check)* EOF;

skolem: declare+ '(' 'assert' '(' (letexp | expr) ')' ')';

check: CS;

declare: '(' 'declare-fun' ID '(' ')' type ')';

letexp: 'let' '(' local* ')' '(' body ')';

body: (letexp | expr);

local: '(' ID expr ')';

type: 'Int'                                              # intType
    | 'Bool'                                             # boolType
    | 'Real'                                             # realType
    ;

expr: ID                                                       # idExpr
    | INT                                                      # intExpr
    | REAL                                                     # realExpr
    | BOOL                                                     # boolExpr
    | op= ('to_real' | 'to_int') expr                          # castExpr
    | 'not' expr                                               # notExpr
    | '-' expr                                                 # negateExpr
    | op=('*' | '/' | 'mod') expr expr                         # binaryExpr
    | op=('+' | '-') expr expr+                                # binaryExpr
    | op=('<' | '<=' | '>' | '>=' | '=' ) expr expr            # binaryExpr
    | op='and' expr expr+                                      # binaryExpr
    | op=('or' | 'xor') expr expr+                             # binaryExpr
    | <assoc=right> op='=>' expr expr                          # binaryExpr
    | <assoc=right> op='->' expr expr                          # binaryExpr
    | '(' expr ')'                                             # parenExpr
    | 'ite' expr expr expr                                     # ifThenElseExpr
    ;

REAL: INT '.' INT;

BOOL: 'true' | 'false';
INT: [0-9]+;


ID: [a-zA-Z_$!~%][a-zA-Z_0-9$!~%]*;

WS: [ \t\n\r\f]+ -> skip;

SL_COMMENT: '//' (~[%\n\r] ~[\n\r]* | /* empty */) ('\r'? '\n')? -> skip;
ML_COMMENT: '(*' .*? '*)' -> skip;
CS: '(check-sat)' -> skip;

ERROR: .;
