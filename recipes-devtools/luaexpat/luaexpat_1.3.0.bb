DESCRIPTION = "LuaExpat is a SAX (Simple API for XML) XML parser based on the Expat library"
LICENSE = "MIT"
HOMEPAGE = "https://github.com/LuaDist/luaexpat"
LIC_FILES_CHKSUM = "file://doc/us/license.html;md5=9e100888b4a39ac08c37fb127fefc458"

DEPENDS += "lua-native lua expat"
RDEPENDS:${PN} += "expat"

SRC_URI = "git://github.com/LuaDist/luaexpat.git;branch=master;protocol=https \
           file://0001-build-patch.patch"

SRCREV = "9bd5324edcdb5608ddfc2f6c2ba388189fe80a7f"
S = "${WORKDIR}/git"
LUA_VERSION = "5.3"

inherit autotools pkgconfig

EXTRA_OEMAKE = "LUA_V=${LUA_VERSION} LUA_INC=-I${RECIPE_SYSROOT}/usr/include EXPAT_INC=-I${RECIPE_SYSROOT}/usr/include DESTDIR=${D}"

do_configure() {
}

do_compile() {
    cd ${S}
    oe_runmake
}

do_install() {
    cd ${S}
    oe_runmake install
}

FILES:${PN} = "${datadir}/lua/${LUA_VERSION} ${libdir}/lua/${LUA_VERSION}"
