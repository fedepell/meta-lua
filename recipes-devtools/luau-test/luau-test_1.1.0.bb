DESCRIPTION = "Sane and simple unit testing framework for Lua"
LICENSE = "MIT"
HOMEPAGE = "https://github.com/IUdalov/u-test"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b4c5dfe141d2ae53dc1cbd5587792303"

DEPENDS += "lua-native lua"

SRC_URI = "git://github.com/IUdalov/u-test;branch=master"

SRCREV = "113259fd238ec1684250da7dd3842e85616608d6"
S = "${WORKDIR}/git"
LUA_VERSION = "5.3"

inherit autotools pkgconfig

do_configure() {
}

do_compile() {
}

do_install() {
    install -d ${D}/${datadir}/lua/${LUA_VERSION}
    install -m 644 ${S}/u-test.lua ${D}/${datadir}/lua/${LUA_VERSION}
}

FILES_${PN} = "${datadir}/lua/${LUA_VERSION}/u-test.lua"
