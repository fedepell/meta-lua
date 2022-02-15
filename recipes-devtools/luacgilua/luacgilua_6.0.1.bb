DESCRIPTION = "CGILua is a tool for creating dynamic HTML pages and manipulating input data from Web forms."
LICENSE = "MIT"
HOMEPAGE = "https://github.com/keplerproject/cgilua"
LIC_FILES_CHKSUM = "file://README.md;md5=9b58738744b5e5a8d569a84761e57ff9"

DEPENDS += "lua-native lua"
RDEPENDS:${PN} += "lualfs"

SRC_URI = "git://github.com/keplerproject/cgilua.git;branch=master;protocol=https \
           file://0001-build-patch.patch"

SRCREV = "239b83a6cafdf523132356d2e022b34fc384fd97"
S = "${WORKDIR}/git"
LUA_VERSION = "5.4"


EXTRA_OEMAKE = "LUA_V=${LUA_VERSION} PREFIX=${D}/usr LUA_DIR=${D}/${datadir}/lua/${LUA_VERSION}"

do_compile() {
}


do_install() {
    cd ${S}
    oe_runmake install
    install -d ${D}/${bindir}
    install -m 755 src/launchers/cgilua.cgi ${D}/${bindir}
    install -m 755 src/launchers/cgilua.fcgi ${D}/${bindir}
}

FILES:${PN} = "${datadir}/lua/${LUA_VERSION}/ ${bindir}/cgilua.cgi ${bindir}/cgilua.fcgi"
