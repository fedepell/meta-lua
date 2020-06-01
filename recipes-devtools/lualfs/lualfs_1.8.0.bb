DESCRIPTION = "LuaFileSystem is a Lua library developed to complement the set of functions related to file systems offered by the standard Lua distribution."
LICENSE = "MIT"
HOMEPAGE = "https://github.com/keplerproject/luafilesystem"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d9b7e441d51a96b17511ee3be5a75857"

DEPENDS += "lua-native lua"

SRC_URI = "git://github.com/keplerproject/luafilesystem.git;branch=master \
           file://0001-build-patch.patch"

SRCREV = "7c6e1b013caec0602ca4796df3b1d7253a2dd258"
S = "${WORKDIR}/git"
LUA_VERSION = "5.3"


EXTRA_OEMAKE = "LUA_VERSION=${LUA_VERSION} PREFIX=${RECIPE_SYSROOT}/usr DESTDIR=${D}/usr"

do_compile() {
    cd ${S}
    oe_runmake
}

do_install() {
    cd ${S}
    oe_runmake install
}

FILES_${PN} = "${libdir}/lua/${LUA_VERSION}/lfs.so"
