grammar DSLGrammar;

start : fields* (layoutNode | node);

fields: VAL FIELD_NAME ASSIGN typeValue;
typeValue: (ARRAY (fStringArray |fBooleanArray | fDoubleArray | fLongArray) |
DICTIONARY (fStringDictionary | fDoubleDictionary | fLongDictionary | fBooleanDictionary) | FBOOLEAN | FLONG | FDOUBLE | FSTRING);

fStringArray: LEFT_BRACE fstringArrValue RIGHT_BRACE;
fBooleanArray: LEFT_BRACE fbooleanArrValue RIGHT_BRACE;
fDoubleArray: LEFT_BRACE fdoubleArrValue RIGHT_BRACE;
fLongArray: LEFT_BRACE flongArrValue RIGHT_BRACE;

fstringArrValue: ((FSTRING COMMA)* FSTRING)?;
fbooleanArrValue: ((FBOOLEAN COMMA)* FBOOLEAN)?;
fdoubleArrValue: ((FDOUBLE COMMA)* FDOUBLE)?;
flongArrValue: ((FLONG COMMA)* FLONG)?;

fStringDictionary: LEFT_BRACE fstringDictValue RIGHT_BRACE;
fDoubleDictionary: LEFT_BRACE fdoubleDictValue RIGHT_BRACE;
fLongDictionary: LEFT_BRACE flongDictValue RIGHT_BRACE;
fBooleanDictionary: LEFT_BRACE fbooleanDictValue RIGHT_BRACE;

fstringDictValue: ((FSTRING TO FSTRING COMMA)* FSTRING TO FSTRING)?;
fdoubleDictValue: ((FSTRING TO FDOUBLE COMMA)* FSTRING TO FDOUBLE)?;
flongDictValue: ((FSTRING TO FLONG COMMA)* FSTRING TO FLONG)?;
fbooleanDictValue: ((FSTRING TO FBOOLEAN COMMA)* FSTRING TO FBOOLEAN)?;

layoutNode: (box | column | row | flowRow | lazyColumn | lazyRow);
node: (textNode | imageNode | textFieldNode);

box: BOX LEFT_FIGURE_BRACE (layoutAttr | viewAttr | tapAttr | layoutNode | node)* RIGHT_FIGURE_BRACE;
column: COLUMN LEFT_FIGURE_BRACE (layoutAttr | viewAttr | tapAttr  | layoutNode | node)* RIGHT_FIGURE_BRACE;
row: ROW LEFT_FIGURE_BRACE (layoutAttr | viewAttr | tapAttr | layoutNode | node)* RIGHT_FIGURE_BRACE;
flowRow: FLOW_ROW LEFT_FIGURE_BRACE (layoutAttr | viewAttr | tapAttr | flowRowAttr | layoutNode | node)* RIGHT_FIGURE_BRACE;
lazyColumn: LAZY_COLUMN LEFT_FIGURE_BRACE (layoutAttr | viewAttr | tapAttr | item | items)* RIGHT_FIGURE_BRACE;
lazyRow: LAZY_ROW LEFT_FIGURE_BRACE (layoutAttr | viewAttr | tapAttr | item | items)* RIGHT_FIGURE_BRACE;
item: ITEM LEFT_FIGURE_BRACE (node | layoutNode) RIGHT_FIGURE_BRACE;
items: ITEMS LEFT_BRACE FIELD_NAME RIGHT_BRACE LEFT_FIGURE_BRACE (node | layoutNode) RIGHT_FIGURE_BRACE;

attrExpression: (ifExpr | fieldExpr);
ifExpr: IF_THEN LEFT_BRACE condition COMMA ifValues RIGHT_BRACE;
condition: consts ((EQUAL | NOT_EQUAL) fieldExpr)?;
consts: (FBOOLEAN | FLONG | FDOUBLE | FSTRING);
fieldExpr: (FIELD_NAME | FIELD_NAME LEFT_SQUARE_BRACE (STRING | LONG) RIGHT_SQUARE_BRACE);
ifValues: (consts | fieldExpr) (COMMA (consts | fieldExpr))?;

layoutAttr: (width | height | weight | gravity | margin);
width: WIDTH LEFT_FIGURE_BRACE (dimension) RIGHT_FIGURE_BRACE;
height: HEIGHT LEFT_FIGURE_BRACE (dimension) RIGHT_FIGURE_BRACE;
weight: WEIGHT LEFT_FIGURE_BRACE (FDOUBLE | attrExpression) RIGHT_FIGURE_BRACE;
gravity: GRAVITY LEFT_FIGURE_BRACE (gravityExpression) RIGHT_FIGURE_BRACE;
gravityExpression: gravityValue | (gravityValue PLUS gravityExpression);
gravityValue: (CENTER | LEFT | RIGHT | TOP | BOTTOM);
margin: MARGIN LEFT_FIGURE_BRACE (insets*) RIGHT_FIGURE_BRACE;
insets: insetsName LEFT_FIGURE_BRACE exact RIGHT_FIGURE_BRACE;
insetsName: (LEFT | RIGHT | TOP | BOTTOM | HORIZONTAL | VERTICAL | ALL);
dimension: (match | exact);
match: (FILL | WRAP);
exact: (DOUBLE | LONG) POINT (NP | AP);

viewAttr: (testTag | alpha | padding | background | isEnabled | isVisible);
testTag: TEST_TAG LEFT_FIGURE_BRACE (FSTRING | attrExpression) RIGHT_FIGURE_BRACE;
alpha: ALPHA LEFT_FIGURE_BRACE (FDOUBLE | attrExpression) RIGHT_FIGURE_BRACE;
padding: PADDING LEFT_FIGURE_BRACE insets* RIGHT_FIGURE_BRACE;
background: BACKGROUND LEFT_FIGURE_BRACE backgroundValue* RIGHT_FIGURE_BRACE;
backgroundValue: (border | cornersRadius | color);
border: BORDER LEFT_FIGURE_BRACE borderAttr* RIGHT_FIGURE_BRACE;
borderAttr: (widthExact | color | dashSize | dashGap);
widthExact: WIDTH LEFT_FIGURE_BRACE exact RIGHT_FIGURE_BRACE;
dashSize: DASH_SIZE LEFT_FIGURE_BRACE exact RIGHT_FIGURE_BRACE;
dashGap: DASH_GAP LEFT_FIGURE_BRACE exact RIGHT_FIGURE_BRACE;
cornersRadius: CORNERS_RADIUS LEFT_FIGURE_BRACE corners* RIGHT_FIGURE_BRACE;
corners: cornerName LEFT_FIGURE_BRACE exact RIGHT_FIGURE_BRACE;
cornerName: (LEFT_TOP | RIGHT_TOP | LEFT_BOTTOM | RIGHT_BOTTOM | ALL);
color: COLOR LEFT_FIGURE_BRACE colorHEX RIGHT_FIGURE_BRACE;
colorHEX: COLOR LEFT_BRACE (HEX | attrExpression) RIGHT_BRACE;
isEnabled: IS_ENABLED LEFT_FIGURE_BRACE (FBOOLEAN | attrExpression) RIGHT_FIGURE_BRACE;
isVisible: IS_VISIBLE LEFT_FIGURE_BRACE (FBOOLEAN | attrExpression) RIGHT_FIGURE_BRACE;

tapAttr: (onTap | onLongTap | onPressedChange);
onTap: ON_TAP LEFT_FIGURE_BRACE tapExpression+ RIGHT_FIGURE_BRACE;
onLongTap: ON_LONG_TAP LEFT_FIGURE_BRACE tapExpression+ RIGHT_FIGURE_BRACE;
onPressedChange: ON_PRESSED_CHANGE LEFT_FIGURE_BRACE tapExpression+ RIGHT_FIGURE_BRACE;

tapExpression: FIELD_NAME ASSIGN (ifExpr | mapExpr | filterExpr | consts | fieldExpr);
mapExpr: FIELD_NAME POINT MAP LEFT_FIGURE_BRACE lambdaParams ARROW condition RIGHT_FIGURE_BRACE (LEFT_SQUARE_BRACE (STRING | LONG) RIGHT_SQUARE_BRACE)?;
filterExpr: FIELD_NAME POINT FILTER LEFT_FIGURE_BRACE lambdaParams ARROW condition RIGHT_FIGURE_BRACE (LEFT_SQUARE_BRACE (STRING | LONG) RIGHT_SQUARE_BRACE)?;
lambdaParams: FIELD_NAME | FIELD_NAME COMMA FIELD_NAME;

flowRowAttr: (maxLinesCount | horizontalSpacing | verticalSpacing);
maxLinesCount: MAX_LINES_COUNT LEFT_FIGURE_BRACE (FLONG | attrExpression) RIGHT_FIGURE_BRACE;
horizontalSpacing: HORIZONTAL_SPACING LEFT_FIGURE_BRACE exact RIGHT_FIGURE_BRACE;
verticalSpacing: VERTICAL_SPACING LEFT_FIGURE_BRACE exact RIGHT_FIGURE_BRACE;

textNode: TEXT_NODE LEFT_FIGURE_BRACE (viewAttr | layoutAttr | tapAttr | textAttr)* RIGHT_FIGURE_BRACE;
textAttr: (text | textConfig | align | overflow | maxLines | lineHeight | letterSpacing);
text: TEXT LEFT_FIGURE_BRACE (FSTRING | attrExpression) RIGHT_FIGURE_BRACE;
textConfig: TEXT_CONFIG LEFT_FIGURE_BRACE configAttr* RIGHT_FIGURE_BRACE;
configAttr: (color | fontSize | fontStyle | isUnderline | isStrikeThrough);
fontSize: FONT_SIZE LEFT_FIGURE_BRACE exact RIGHT_FIGURE_BRACE;
fontStyle: FONT_STYLE LEFT_FIGURE_BRACE fontStyleValue RIGHT_FIGURE_BRACE;
fontStyleValue: (REGULAR | BOLD | EXTRA_BOLD_ITALIC | BOLD_ITALIC | SEMI_BOLD | MEDIUM | ALI_BOLD |
ALI_REGULAR | ALI_LIGHT);
isUnderline: IS_UNDERLINE LEFT_FIGURE_BRACE (FBOOLEAN | attrExpression) RIGHT_FIGURE_BRACE;
isStrikeThrough: IS_STRIKE_THROUGH LEFT_FIGURE_BRACE (FBOOLEAN | attrExpression) RIGHT_FIGURE_BRACE;
align: ALIGN LEFT_FIGURE_BRACE alignValue RIGHT_FIGURE_BRACE;
alignValue: (CENTER | START | END | JUSTIFY);
overflow: OVERFLOW LEFT_FIGURE_BRACE overflowValue RIGHT_FIGURE_BRACE;
overflowValue: ELLIPSIS | CLIP;
maxLines: MAX_LINES LEFT_FIGURE_BRACE (FLONG | attrExpression) RIGHT_FIGURE_BRACE;
lineHeight: LINE_HEIGHT LEFT_FIGURE_BRACE exact RIGHT_FIGURE_BRACE;
letterSpacing: LETTER_SPACING LEFT_FIGURE_BRACE exact RIGHT_FIGURE_BRACE;

imageNode: IMAGE_NODE LEFT_FIGURE_BRACE (imageAttr | layoutAttr | tapAttr | viewAttr)* RIGHT_FIGURE_BRACE;
imageAttr: (source | placeholder | placeholderTint | tint | resizeMode | animateChanges);
source: SOURCE LEFT_FIGURE_BRACE (FSTRING | attrExpression) RIGHT_FIGURE_BRACE;
placeholder: PLACEHOLDER LEFT_FIGURE_BRACE colorHEX RIGHT_FIGURE_BRACE;
placeholderTint: PLACEHOLDER_TINT LEFT_FIGURE_BRACE colorHEX RIGHT_FIGURE_BRACE;
tint: TINT LEFT_FIGURE_BRACE colorHEX RIGHT_FIGURE_BRACE;
resizeMode: RESIZE_MODE LEFT_FIGURE_BRACE resizeModeValue RIGHT_FIGURE_BRACE;
resizeModeValue: ASPECT_FIT |  SCALE_TO_FILL | ASPECT_FILL;
animateChanges: ANIMATE_CHANGES LEFT_FIGURE_BRACE animateChangesValue RIGHT_FIGURE_BRACE;
animateChangesValue: (NONE | CROSS_FADE);

textFieldNode: TEXT_FIELD_NODE LEFT_FIGURE_BRACE (textFieldAttr | layoutAttr | tapAttr | viewAttr)* RIGHT_FIGURE_BRACE;
textFieldAttr: (text | textFieldConfig | lineHeight | letterSpacing | isMultiline | keyboardOptions);
textFieldConfig: CONFIG LEFT_FIGURE_BRACE configAttr* RIGHT_FIGURE_BRACE;
keyboardOptions: KEYBOARD_OPTIONS LEFT_FIGURE_BRACE keyboardOptionsValue* RIGHT_FIGURE_BRACE;
keyboardOptionsValue: (capitalization | autoCorrect | keyboardType | imeAction | inputAccessoryAction);
capitalization: CAPITALIZATION LEFT_FIGURE_BRACE capitalizationValue RIGHT_FIGURE_BRACE;
capitalizationValue: (NONE | CHARACTERS | WORDS | SENTENCES);
autoCorrect: AUTO_CORRECT LEFT_FIGURE_BRACE (FBOOLEAN | attrExpression) RIGHT_FIGURE_BRACE;
keyboardType: KEYBOARD_TYPE LEFT_FIGURE_BRACE keyboardTypeValue RIGHT_FIGURE_BRACE;
keyboardTypeValue: (TEXT | ASCII | NUMBER | PHONE | URI | EMAIL | PASSWORD | NUMBER_PASSWORD);
imeAction: IME_ACTION LEFT_FIGURE_BRACE imeActionValue RIGHT_FIGURE_BRACE;
imeActionValue: (DEFAULT | NONE | GO | SEARCH | SEND | PREVIOUS | NEXT | DONE);
inputAccessoryAction: INPUT_ACCESSORY_ACTION LEFT_FIGURE_BRACE imeActionValue RIGHT_FIGURE_BRACE;
isMultiline: IS_MULTILINE LEFT_FIGURE_BRACE (FBOOLEAN | attrExpression) RIGHT_FIGURE_BRACE;

BOX: 'Box';
COLUMN: 'Column';
FLOW_ROW: 'FlowRow';
LAZY_COLUMN: 'LazyColumn';
LAZY_ROW: 'LazyRow';
ROW: 'Row';
TEXT_NODE: 'Text';
TEXT_FIELD_NODE: 'TextField';
IMAGE_NODE: 'Image';

LEFT_FIGURE_BRACE: '{';
RIGHT_FIGURE_BRACE: '}';
LEFT_BRACE: '(';
RIGHT_BRACE: ')';
LEFT_SQUARE_BRACE: '[';
RIGHT_SQUARE_BRACE: ']';
LEFT_ANGLE_BRACE: '<';
RIGHT_ANGLE_BRACE: '>';

WIDTH: 'width';
HEIGHT: 'height';
WEIGHT: 'weight';
GRAVITY: 'gravity';
MARGIN: 'margin';
TEST_TAG: 'testTag';
ALPHA: 'alpha';
PADDING: 'padding';
BACKGROUND: 'background';
IS_ENABLED: 'isEnabled';
IS_VISIBLE: 'isVisible';
BORDER: 'border';
CORNERS_RADIUS: 'cornersRadius';
COLOR: 'color';
DASH_SIZE: 'dashSize';
DASH_GAP: 'dashGap';
TEXT: 'text';
CONFIG: 'config';
TEXT_CONFIG: 'textConfig';
FONT_SIZE: 'fontSize';
FONT_STYLE: 'fontStyle';
IS_UNDERLINE: 'isUnderline';
IS_STRIKE_THROUGH: 'isStrikeThrough';
ALIGN: 'align';
OVERFLOW: 'overflow';
MAX_LINES: 'maxLines';
LINE_HEIGHT: 'lineHeight';
LETTER_SPACING: 'letterSpacing';
KEYBOARD_OPTIONS: 'keyboardOptions';
CAPITALIZATION: 'capitalization';
AUTO_CORRECT: 'autoCorrect';
KEYBOARD_TYPE: 'keyboardType';
IME_ACTION: 'imeAction';
INPUT_ACCESSORY_ACTION: 'inputAccessoryAction';
IS_MULTILINE: 'isMultiline';
SOURCE: 'source';
PLACEHOLDER: 'placeholder';
PLACEHOLDER_TINT: 'placeholderTint';
TINT: 'tint';
RESIZE_MODE: 'resizeMode';
ANIMATE_CHANGES: 'animateChanges';
MAX_LINES_COUNT: 'maxLinesCount';
HORIZONTAL_SPACING: 'horizontalSpacing';
VERTICAL_SPACING: 'verticalSpacing';
VAL: 'val';
TO: 'to';
MAP: 'map';
IF_THEN: 'ifThen';
FILTER: 'filter';
ARRAY: 'Array';
DICTIONARY: 'Dictionary';
STRING_TYPE: 'String';
BOOLEAN_TYPE: 'Boolean';
DOUBLE_TYPE: 'Double';
LONG_TYPE: 'Long';
ITEM: 'item';
ITEMS: 'items';
ON_TAP: 'onTap';
ON_LONG_TAP: 'onLongTap';
ON_PRESSED_CHANGE: 'onPressedChange';

FILL: 'fill';
WRAP: 'wrap';
JUSTIFY: 'justify';
ELLIPSIS: 'ellipsis';
CLIP: 'clip';
ASPECT_FIT: 'aspectFit';
SCALE_TO_FILL: 'scaleToFill';
ASPECT_FILL: 'aspectFill';
NONE: 'none';
CROSS_FADE: 'crossFade';

POINT: '.';
COMMA: ',';
DOUBLE_QUOTES: '"';
LATTICE: '#';

NP: 'np';
AP: 'ap';

PLUS: '+';
MINUS: '-';
ASSIGN: '=';
EQUAL: '==';
NOT_EQUAL: '!=';
ARROW: '->';

CENTER: 'center';
LEFT: 'left';
RIGHT: 'right';
TOP: 'top';
BOTTOM: 'bottom';
LEFT_TOP: 'leftTop';
RIGHT_TOP: 'rightTop';
LEFT_BOTTOM: 'leftBottom';
RIGHT_BOTTOM: 'rightBottom';
ALL: 'all';
START: 'start';
END: 'end';
HORIZONTAL: 'horizontal';
VERTICAL: 'vertical';

REGULAR: 'regular';
BOLD: 'bold';
EXTRA_BOLD_ITALIC: 'extraBoldItalic';
BOLD_ITALIC: 'boldItalic';
SEMI_BOLD: 'semiBold';
MEDIUM: 'medium';
ALI_BOLD: 'aliBold';
ALI_REGULAR: 'aliRegular';
ALI_LIGHT: 'aliLight';

CHARACTERS: 'characters';
WORDS: 'words';
SENTENCES: 'sentences';

ASCII: 'ascii';
NUMBER: 'number';
PHONE: 'phone';
URI: 'uri';
EMAIL: 'email';
PASSWORD: 'password';
NUMBER_PASSWORD: 'numberPassword';

DEFAULT: 'default';
GO: 'go';
SEARCH: 'search';
SEND: 'send';
PREVIOUS: 'previous';
NEXT: 'next';
DONE: 'done';

HEX: DOUBLE_QUOTES LATTICE[a-fA-F0-9]+ DOUBLE_QUOTES;
STRING: DOUBLE_QUOTES (~["])* DOUBLE_QUOTES;
FSTRING: STRING POINT C;
BOOLEAN: ('false' | 'true');
FBOOLEAN: BOOLEAN POINT C;
DOUBLE: LONG POINT([0-9])+;
FDOUBLE: DOUBLE POINT C;
LONG: MINUS? ('0' | [1-9][0-9]*);
FLONG: LONG POINT C;
FIELD_NAME: [a-zA-Z]+;
C: 'c';

WS: [ \r\n\t]+ -> skip;
