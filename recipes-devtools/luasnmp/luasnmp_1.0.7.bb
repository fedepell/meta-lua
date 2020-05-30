DESCRIPTION = "LuaSNMP is a binding to the netsnmp library."
LICENSE = "MIT"
HOMEPAGE = "https://github.com/hleuwer/luasnmp"
LIC_FILES_CHKSUM = "file://LICENSE;md5=efa96ceb109a86d8ee112633f365bcc8"

DEPENDS += "lua-native lua net-snmp"
RDEPENDS_${PN} += "net-snmp-lib-netsnmp luapl"

SRC_URI = "git://github.com/hleuwer/luasnmp.git;branch=master \
           file://0001-build-patch.patch"

SRCREV = "a377eb9d5ee203f81712434ea5355497d7f6d14d"
S = "${WORKDIR}/git"
LUA_VERSION = "5.3"

inherit autotools pkgconfig

EXTRA_OEMAKE = "LV=${LUA_VERSION} LUA=${RECIPE_SYSROOT}/usr INSTALL_ROOT=${D}/usr"

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

FILES_${PN} = "${datadir}/lua/${LUA_VERSION} ${libdir}/lua/${LUA_VERSION}"
