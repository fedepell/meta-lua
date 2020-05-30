DESCRIPTION = "Penlight: A set of pure Lua libraries focusing on input data handling (such as reading configuration files), functional programming (such as map, reduce, placeholder expressions,etc), and OS path management."
LICENSE = "MIT"
HOMEPAGE = "https://github.com/Tieske/Penlight"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=0a2993b604147dcce1ea113b72b618cd"

DEPENDS += "lua-native lua"

SRC_URI = "git://github.com/Tieske/Penlight.git;branch=master"

SRCREV = "e469fa08b71055e1bc419f78754a1d830956e8d5"
S = "${WORKDIR}/git"
LUA_VERSION = "5.3"

inherit autotools pkgconfig

do_configure() {
}

do_compile() {
}

do_install() {
    install -d ${D}/${datadir}/lua/${LUA_VERSION}
    cd ${S}/lua
    cp -r pl ${D}/${datadir}/lua/${LUA_VERSION}
}

FILES_${PN} = "${datadir}/lua/${LUA_VERSION}/pl"
