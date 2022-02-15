DESCRIPTION = "Sol3 (sol2 v3.0) - a C++ <-> Lua API wrapper with advanced features and top notch performance - is here, and it's great!"
LICENSE = "MIT"
HOMEPAGE = "https://github.com/ThePhD/sol2"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=ce04e78f0c06a8a22851d023215d658a"

DEPENDS += "lua-native lua"

SRC_URI = "git://github.com/ThePhD/sol2.git;branch=develop;protocol=https"

SRCREV = "e09d2ffef8f4edb1e67aef881c6ad3c58a30c5d6"
S = "${WORKDIR}/git"
LUA_VERSION = "5.4"

inherit pkgconfig cmake

