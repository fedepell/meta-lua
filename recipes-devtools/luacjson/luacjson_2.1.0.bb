DESCRIPTION = "Lua CJSON is a fast JSON encoding/parsing module for Lua"
LICENSE = "MIT"
HOMEPAGE = "https://github.com/mpx/lua-cjson/"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b1fee3afe4f4a4b26c13016123b2d08a"

DEPENDS += "lua-native lua"

SRC_URI = "git://github.com/mpx/lua-cjson.git;branch=master \
           file://0001-build-patch.patch"

SRCREV = "e8972ac754788d3ef10a57a36016d6c3e85ba20d"
S = "${WORKDIR}/git"
LUA_VERSION = "5.3"

inherit autotools pkgconfig

EXTRA_OEMAKE = "LUA_V=${LUA_VERSION} PREFIX=${D}/usr"
CFLAGS_append = " -I${RECIPE_SYSROOT}/usr/include"

do_configure() {
}

do_compile() {
    cd ${S}
    oe_runmake
}

do_install() {
    cd ${S}
    oe_runmake install install-extra
}

FILES_${PN} = "${datadir}/lua/${LUA_VERSION} ${libdir}/lua/${LUA_VERSION} /usr/bin/json2lua /usr/bin/lua2json"
