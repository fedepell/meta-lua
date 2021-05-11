DESCRIPTION = "luasocket is a networking support library for the Lua language."
LICENSE = "MIT"
HOMEPAGE = "https://github.com/diegonehab/luasocket"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ab6706baf6d39a6b0fa2613a3b0831e7"

DEPENDS += "lua-native lua"

SRC_URI = "git://github.com/diegonehab/luasocket.git;branch=master \
           file://0001-build-patch.patch"

SRCREV = "5b18e475f38fcf28429b1cc4b17baee3b9793a62"
S = "${WORKDIR}/git"
LUA_VERSION = "5.3"

inherit autotools pkgconfig

EXTRA_OEMAKE = "-f makefile LUAV=${LUA_VERSION} PLAT=linux INSTALL_TOP=${D}/usr DEBUG=NODEBUG LUAINC_linux=${RECIPE_SYSROOT}/usr/include"

do_compile() {
    cd ${S}/src
    oe_runmake linux
}

do_install() {
    cd ${S}/src
    oe_runmake install-unix
}

FILES_${PN} = "${datadir}/lua/${LUA_VERSION} ${libdir}/lua/${LUA_VERSION}"
