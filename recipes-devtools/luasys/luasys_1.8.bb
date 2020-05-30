DESCRIPTION = "LuaSys is a portable Lua library providing access to system and networking functions."
LICENSE = "MIT"
HOMEPAGE = "https://github.com/tnodir/luasys"
LIC_FILES_CHKSUM = "file://COPYRIGHT;md5=eb20c1e17a9cbfb068bd4d63a5d56544"

DEPENDS += "lua-native lua"

SRC_URI = "git://github.com/tnodir/luasys.git;branch=master \
           file://0001-build-patch.patch \
           file://0002-lua53-compat.patch"

SRCREV = "8f0c4480fed804ff578c5fb3ddd6ec722e11067d"
S = "${WORKDIR}/git"
LUA_VERSION = "5.3"

inherit autotools pkgconfig

EXTRA_OEMAKE = "LUA_V=${LUA_VERSION}"
CFLAGS_append = " -I${RECIPE_SYSROOT}/usr/include"

do_configure() {
}

do_compile() {
    cd ${S}/src
    oe_runmake linux
}

do_install() {
    install -d ${D}/${libdir}/lua/${LUA_VERSION}
    install -m 644 ${S}/src/sys.so ${D}/${libdir}/lua/${LUA_VERSION}    
}

FILES_${PN} = "${libdir}/lua/${LUA_VERSION}/sys.so"
