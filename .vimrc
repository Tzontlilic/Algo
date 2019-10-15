" Configuration file for vim
set modelines=0		" CVE-2007-2438

" Normally we use vim-extensions. If you want true vi-compatibility
" remove change the following statements
set nocompatible	" Use Vim defaults instead of 100% vi compatibility
set backspace=2		" more powerful backspacing
set mouse= 		" 关闭鼠标
" Don't write backup file if vim is being called by "crontab -e"
au BufWrite /private/tmp/crontab.* set nowritebackup nobackup
" Don't write backup file if vim is being called by "chpass"
au BufWrite /private/etc/pw.* set nowritebackup nobackup

let skip_defaults_vim=1



" 常规设置----------------------------------------------------
set guicursor=i:ver1
set nu!      		" 显示行号

syntax on 		" 语法高亮

set hlsearch 		" 搜索高亮

set autoindent 		" 自动对齐

set smartindent     " 智能对齐

set shiftwidth=4      " 将自动换行缩紧设置为4个空格

set incsearch

set autoread 		" 文件自动检测外部更改

set ruler 		" 显示标尺

set guioptions-=r 	" 隐藏右侧滚动条

set guioptions-=L 	" 隐藏左侧滚动条

set guioptions-=b 	" 隐藏底部滚动条

set cursorline    	" 突出显示当前行

set ts=4		" 设置tab为四个空格

set expandtab
" -------------------------------------------------------------



" 主题 --------------------------------------------------------
colorscheme aurora
" -------------------------------------------------------------



" 代码折叠插件配置 ---------------------------------------------
set foldmethod=indent  " 根据每行的缩进开启折叠
set foldlevel=99

" 使用空格来代替 za 进行缩进操作

nnoremap <space> za
" --------------------------------------------------------------




" Powerline 插件配置 --------------------------------------------
" 将字体设置为Meslo LG S DZ Regular for PowerLine 13号大小
set guifont=Meslo:5

let g:Powerline_Symbols = 'fancy'

set laststatus=2 	" 必须设置为2，否则状态栏不显示
set t_Co=256
let g:Powerline_colorscheme='solarized256'

" 希望看到折叠代码的文档字符串
let g:SimpylFold_docstring_preview=1
" ----------------------------------------------------------------


" 缩进指示线插件配置 ---------------------------------------------
let g:indentLine_char='¦'
let g:indentLine_enable = 1 " 使插件生效
" ----------------------------------------------------------------




" 键盘映射 -------------------------------------------------------
inoremap ( ()<LEFT>
inoremap [ []<LEFT>
inoremap { {}<LEFT>
inoremap jk <Esc>
nnoremap <S-J> <C-W><C-J>
nnoremap <S-K> <C-W><C-K>
nnoremap <S-H> <C-W><C-H>
nnoremap <S-L> <C-W><C-L>
nmap <tab> v>
nmap <s-tab> v<
nmap <F5> :NERDTreeToggle<cr>
" ----------------------------------------------------------------




" vundle 环境配置 ------------------------------------------------
filetype off
set rtp+=~/.vim/bundle/Vundle.vim
" Vundle 管理的插件列表必须位于 vundle#begin() 和 vundle#end() 之间
call vundle#begin()
Plugin 'VundleVim/Vundle.vim'
Plugin 'scrooloose/nerdtree'
Plugin 'valloric/youcompleteme'
Plugin 'rafalbromirski/vim-aurora'  	" 配色
Plugin 'vim-powerline'			" powerline插件
Plugin 'vim-colors-solarized' 		" 状态栏配色
Plugin 'Yggdroot/indentLine'		" 代码缩进指示线
Plugin 'tmhedberg/SimpylFold'  		" 折叠代码
call vundle#end()
filetype plugin indent on 
" ----------------------------------------------------------------
