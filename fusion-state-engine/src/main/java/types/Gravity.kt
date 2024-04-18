package types

data class Gravity(val value: GravityEnum?)

enum class GravityEnum {
    LEFT, RIGHT, TOP, BOTTOM, CENTER, LEFT_TOP, RIGHT_TOP, LEFT_BOTTOM, RIGHT_BOTTOM, LEFT_CENTER,
    RIGHT_CENTER, TOP_CENTER, BOTTOM_CENTER;
}