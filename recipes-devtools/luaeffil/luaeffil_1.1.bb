DESCRIPTION = "Multithreading support for Lua"
LICENSE = "MIT"
HOMEPAGE = "https://github.com/effil/effil"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b314c51e3cb765a16b1eaf848e1dd2c5"

DEPENDS += "lua-native lua"

SRC_URI = "gitsm://github.com/effil/effil.git;branch=master"

SRCREV = "e208629c4ccf5d178aafaf7f0f067c0e5bed33a0"
S = "${WORKDIR}/git"
LUA_VERSION = "5.3"

inherit pkgconfig cmake

do_install() {
    install -d ${D}/${libdir}/lua/${LUA_VERSION}
    install -m 644 effil.so ${D}/${libdir}/lua/${LUA_VERSION}
}

FILES_${PN} = "${libdir}/lua/${LUA_VERSION}/effil.so"
