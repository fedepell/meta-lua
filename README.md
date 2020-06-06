# meta-lua
Yocto layer with a collection of recipes for Lua libraries and tools.

This layer was developed for the *dunfell* release and the current master
corresponds to the work done on this. In the future it may be branched per
release as it is usually done with Yocto layers.

This layer contains receipes pointed at Lua 5.3 usage. Most of the changes
proposed in the patches are either changes to make the library compatible with
Lua 5.3 or to make the build procedure fit the Yocto philosophy. When possible
patches were always submitted for upstream merging.

This layer depends on a couple of other layers (as some of the Lua libraries
are wrappers to their C equivalents), please check the layer configuration file
for details.

To use this layer you need to add a reference to it in the configuration of
your build system, ie.:

```
  BBLAYERS ?= " \
    /path/to/yocto/meta \
    /path/to/yocto/meta-poky \
    /path/to/yocto/meta-yocto-bsp \
    /path/to/yocto/meta-openembedded/meta-oe \
    /path/to/yocto/meta-openembedded/meta-networking \
    /path/to/yocto/meta-lua \
    " 
```