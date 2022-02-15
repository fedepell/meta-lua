DESCRIPTION = "JSON parser/encoder for Lua Parses JSON using LPEG for speed and flexibility"
LICENSE = "MIT"
HOMEPAGE = "https://github.com/harningt/luajson"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ac0d9618a43915269abea2cb61c95cac"

DEPENDS += "lua-native lua"
RDEPENDS:${PN} += "lualpeg"

SRC_URI = "git://github.com/harningt/luajson.git;branch=master;protocol=https \
           file://0001-build-patch.patch"

SRCREV = "b5e3c9bf73cb7908e246230e991d853aaa35552d"
S = "${WORKDIR}/git"
LUA_VERSION = "5.4"


EXTRA_OEMAKE = "LUA_V=${LUA_VERSION} PREFIX=${D}/usr"

do_compile() {
    cd ${S}
    oe_runmake all
}


do_install() {
    cd ${S}
    oe_runmake install
}

FILES:${PN} = "${datadir}/lua/${LUA_VERSION}/"
