DESCRIPTION = "Multithreading support for Lua"
LICENSE = "MIT"
HOMEPAGE = "https://github.com/effil/effil"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b314c51e3cb765a16b1eaf848e1dd2c5"

DEPENDS += "lua-native lua"

SRC_URI = "gitsm://github.com/effil/effil.git;branch=master;protocol=https"

SRCREV = "b3380a78797c2ddea90dea152f9825630c66bca6"
S = "${WORKDIR}/git"
LUA_VERSION = "5.3"

inherit pkgconfig cmake

do_install() {
    install -d ${D}/${libdir}/lua/${LUA_VERSION}
    install -m 644 effil.so ${D}/${libdir}/lua/${LUA_VERSION}
}

FILES:${PN} = "${libdir}/lua/${LUA_VERSION}/effil.so"
