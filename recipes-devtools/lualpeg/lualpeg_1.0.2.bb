DESCRIPTION = "LPeg is a new pattern-matching library for Lua, based on Parsing Expression Grammars (PEGs)"
LICENSE = "MIT"
HOMEPAGE = "http://www.inf.puc-rio.br/~roberto/lpeg/"
LIC_FILES_CHKSUM = "file://lpeg.html;md5=1db2940ebc612e76c1b0fdcccee843a5"

DEPENDS += "lua-native lua"

SRC_URI = "http://www.inf.puc-rio.br/~roberto/lpeg/lpeg-1.0.2.tar.gz \
           file://0001-build-patch.patch"

SRC_URI[sha256sum] = "48d66576051b6c78388faad09b70493093264588fcd0f258ddaab1cdd4a15ffe"

S = "${WORKDIR}/lpeg-1.0.2"
LUA_VERSION = "5.4"

inherit autotools pkgconfig

EXTRA_OEMAKE = "-f makefile LUA_V=${LUA_VERSION} LUADIR=${RECIPE_SYSROOT}/usr/lua"
CFLAGS:append = " -I${LUADIR} -fPIC"

do_configure() {
}

do_compile() {
    cd ${S}
    oe_runmake linux
}

do_install() {
    install -d ${D}/${libdir}/lua/${LUA_VERSION}
    install -m 644 ${S}/lpeg.so ${D}/${libdir}/lua/${LUA_VERSION}
    install -d ${D}/${datadir}/lua/${LUA_VERSION}
    install -m 644 ${S}/re.lua ${D}/${datadir}/lua/${LUA_VERSION}
}

FILES:${PN} = "${libdir}/lua/${LUA_VERSION}/lpeg.so ${datadir}/lua/${LUA_VERSION}/re.lua"
