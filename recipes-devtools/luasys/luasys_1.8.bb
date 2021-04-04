DESCRIPTION = "LuaSys is a portable Lua library providing access to system and networking functions."
LICENSE = "MIT"
HOMEPAGE = "https://github.com/tnodir/luasys"
LIC_FILES_CHKSUM = "file://COPYRIGHT;md5=eb20c1e17a9cbfb068bd4d63a5d56544"

DEPENDS += "lua-native lua"

SRC_URI = "git://github.com/tnodir/luasys.git;branch=master \
           file://0001-build-patch.patch file://0002-Remove_sysctl_header.patch"

SRCREV = "79e99a450f52b37598d0c29dd736e8c2d071efe2"
S = "${WORKDIR}/git"
LUA_VERSION = "5.3"

inherit autotools pkgconfig

EXTRA_OEMAKE = "LUA_V=${LUA_VERSION}"
CFLAGS_append = " -I${RECIPE_SYSROOT}/usr/include -fPIC"

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

INSANE_SKIP_${PN} += "ldflags"
