*Dashboard Source Code*
=======================

[![gitmoji](https://img.shields.io/badge/gitmoji-%20😜%20😍-FFDD67.svg)](https://gitmoji.carloscuesta.me)

**This is an example application for my talk about Web Components and Google Polymer.**

*Copyright © 2016-2017 Marcus Fihlon*

This program is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License along with this program.  If not, see <http://www.gnu.org/licenses/>.

## Prerequisites

You need a local web server or an editor with an integrated web server like [Atom](https://atom.io) with [Live Server Package](https://atom.io/packages/atom-live-server) and you need [Bower](https://bower.io), a package manager for the web.

## Installation

```
mkdir sessions
cd sessions
git init
git remote add -f origin https://github.com/McPringle/sessions.git
git config core.sparseCheckout true
echo "WebComponents Introduction/source" >> .git/info/sparse-checkout
git pull origin master
cd WebComponents\ Introduction/source
bower install
```

## Start

Start a web server configured to serve the files from the source directory and load the `index.html` file.
