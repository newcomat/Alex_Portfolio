	.file	"FinalProjectAlexNewcomer.c"
	.section	.rodata
.LC0:
	.string	"Enter name: "
.LC1:
	.string	"%s"
.LC2:
	.string	"Enter password: "
.LC3:
	.string	"%d"
	.text
	.globl	ReadUserInfo
	.type	ReadUserInfo, @function
ReadUserInfo:
.LFB0:
	.cfi_startproc
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	subq	$16, %rsp
	movl	$.LC0, %edi
	movl	$0, %eax
	call	printf
	leaq	-5(%rbp), %rax
	movq	%rax, %rsi
	movl	$.LC1, %edi
	movl	$0, %eax
	call	__isoc99_scanf
	movl	$.LC2, %edi
	movl	$0, %eax
	call	printf
	leaq	-4(%rbp), %rax
	movq	%rax, %rsi
	movl	$.LC3, %edi
	movl	$0, %eax
	call	__isoc99_scanf
	leave
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE0:
	.size	ReadUserInfo, .-ReadUserInfo
	.globl	CheckUserPermissionAccess
	.type	CheckUserPermissionAccess, @function
CheckUserPermissionAccess:
.LFB1:
	.cfi_startproc
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	movl	%edi, -4(%rbp)
	cmpl	$123, -4(%rbp)
	jne	.L3
	movl	$1, %eax
	jmp	.L4
.L3:
	movl	$0, %eax
.L4:
	popq	%rbp
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE1:
	.size	CheckUserPermissionAccess, .-CheckUserPermissionAccess
	.section	.rodata
.LC4:
	.string	"Jim"
.LC5:
	.string	"A"
.LC6:
	.string	"Tom"
.LC7:
	.string	"C"
.LC8:
	.string	"Ben"
.LC9:
	.string	"Alice"
.LC10:
	.string	"D"
.LC11:
	.string	"Ruby"
.LC12:
	.string	"F"
.LC13:
	.string	"%s\t %s\n"
	.text
	.globl	DisplayStudentInformation
	.type	DisplayStudentInformation, @function
DisplayStudentInformation:
.LFB2:
	.cfi_startproc
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	pushq	%rbx
	subq	$40, %rsp
	.cfi_offset 3, -24
	movq	%rsp, %rax
	movq	%rax, %rbx
	movl	$5, -36(%rbp)
	movl	-36(%rbp), %eax
	movslq	%eax, %r8
	subq	$1, %r8
	movq	%r8, -32(%rbp)
	movslq	%eax, %r8
	movq	%r8, %rsi
	movl	$0, %edi
	movslq	%eax, %rsi
	movq	%rsi, %rdx
	movl	$0, %ecx
	cltq
	salq	$4, %rax
	leaq	7(%rax), %rdx
	movl	$16, %eax
	subq	$1, %rax
	addq	%rdx, %rax
	movl	$16, %edi
	movl	$0, %edx
	divq	%rdi
	imulq	$16, %rax, %rax
	subq	%rax, %rsp
	movq	%rsp, %rax
	addq	$7, %rax
	shrq	$3, %rax
	salq	$3, %rax
	movq	%rax, -24(%rbp)
	movq	-24(%rbp), %rax
	movq	$.LC4, (%rax)
	movq	-24(%rbp), %rax
	movq	$.LC5, 8(%rax)
	movq	-24(%rbp), %rax
	movq	$.LC6, 16(%rax)
	movq	-24(%rbp), %rax
	movq	$.LC7, 24(%rax)
	movq	-24(%rbp), %rax
	movq	$.LC8, 32(%rax)
	movq	-24(%rbp), %rax
	movq	$.LC7, 40(%rax)
	movq	-24(%rbp), %rax
	movq	$.LC9, 48(%rax)
	movq	-24(%rbp), %rax
	movq	$.LC10, 56(%rax)
	movq	-24(%rbp), %rax
	movq	$.LC11, 64(%rax)
	movq	-24(%rbp), %rax
	movq	$.LC12, 72(%rax)
	movl	$0, -40(%rbp)
	jmp	.L6
.L7:
	movq	-24(%rbp), %rax
	movl	-40(%rbp), %edx
	movslq	%edx, %rdx
	salq	$4, %rdx
	addq	%rdx, %rax
	addq	$8, %rax
	movq	(%rax), %rdx
	movq	-24(%rbp), %rax
	movl	-40(%rbp), %ecx
	movslq	%ecx, %rcx
	salq	$4, %rcx
	addq	%rcx, %rax
	movq	(%rax), %rax
	movq	%rax, %rsi
	movl	$.LC13, %edi
	movl	$0, %eax
	call	printf
	addl	$1, -40(%rbp)
.L6:
	movl	-40(%rbp), %eax
	cmpl	-36(%rbp), %eax
	jl	.L7
	movq	%rbx, %rsp
	movq	-8(%rbp), %rbx
	leave
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE2:
	.size	DisplayStudentInformation, .-DisplayStudentInformation
	.section	.rodata
.LC14:
	.string	"Adjust grades for students? "
.LC15:
	.string	"%c"
	.align 8
.LC16:
	.string	"Enter the GPA for students one at a time "
.LC17:
	.string	"%s "
.LC18:
	.string	"%f"
	.align 8
.LC19:
	.string	"You have successfully updated class grades.  The grades are now as follows: "
.LC20:
	.string	"%s\t %.0f\n"
	.text
	.globl	main
	.type	main, @function
main:
.LFB3:
	.cfi_startproc
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	pushq	%rbx
	subq	$72, %rsp
	.cfi_offset 3, -24
	movq	%rsp, %rax
	movq	%rax, %rbx
	movl	$5, -36(%rbp)
	movl	-36(%rbp), %eax
	movslq	%eax, %r8
	subq	$1, %r8
	movq	%r8, -32(%rbp)
	movslq	%eax, %r8
	movq	%r8, %rsi
	movl	$0, %edi
	movslq	%eax, %rsi
	movq	%rsi, %rdx
	movl	$0, %ecx
	cltq
	salq	$4, %rax
	leaq	7(%rax), %rdx
	movl	$16, %eax
	subq	$1, %rax
	addq	%rdx, %rax
	movl	$16, %ecx
	movl	$0, %edx
	divq	%rcx
	imulq	$16, %rax, %rax
	subq	%rax, %rsp
	movq	%rsp, %rax
	addq	$7, %rax
	shrq	$3, %rax
	salq	$3, %rax
	movq	%rax, -24(%rbp)
	movq	-24(%rbp), %rax
	movq	$.LC4, (%rax)
	movq	-24(%rbp), %rax
	movq	$.LC5, 8(%rax)
	movq	-24(%rbp), %rax
	movq	$.LC6, 16(%rax)
	movq	-24(%rbp), %rax
	movq	$.LC7, 24(%rax)
	movq	-24(%rbp), %rax
	movq	$.LC8, 32(%rax)
	movq	-24(%rbp), %rax
	movq	$.LC7, 40(%rax)
	movq	-24(%rbp), %rax
	movq	$.LC9, 48(%rax)
	movq	-24(%rbp), %rax
	movq	$.LC10, 56(%rax)
	movq	-24(%rbp), %rax
	movq	$.LC11, 64(%rax)
	movq	-24(%rbp), %rax
	movq	$.LC12, 72(%rax)
	movl	$.LC0, %edi
	movl	$0, %eax
	call	printf
	leaq	-62(%rbp), %rax
	movq	%rax, %rsi
	movl	$.LC1, %edi
	movl	$0, %eax
	call	__isoc99_scanf
	movl	$.LC2, %edi
	movl	$0, %eax
	call	printf
	leaq	-60(%rbp), %rax
	movq	%rax, %rsi
	movl	$.LC3, %edi
	movl	$0, %eax
	call	__isoc99_scanf
	movl	-60(%rbp), %eax
	movl	%eax, %edi
	call	CheckUserPermissionAccess
	testb	%al, %al
	je	.L9
	movl	$0, %eax
	call	DisplayStudentInformation
	movl	$.LC14, %edi
	call	puts
	leaq	-61(%rbp), %rax
	movq	%rax, %rsi
	movl	$.LC15, %edi
	movl	$0, %eax
	call	__isoc99_scanf
	leaq	-61(%rbp), %rax
	movq	%rax, %rsi
	movl	$.LC15, %edi
	movl	$0, %eax
	call	__isoc99_scanf
	movzbl	-61(%rbp), %eax
	cmpb	$89, %al
	jne	.L9
	movl	$.LC16, %edi
	call	puts
	movq	-24(%rbp), %rax
	movq	(%rax), %rax
	movq	%rax, %rsi
	movl	$.LC17, %edi
	movl	$0, %eax
	call	printf
	leaq	-56(%rbp), %rax
	movq	%rax, %rsi
	movl	$.LC18, %edi
	movl	$0, %eax
	call	__isoc99_scanf
	movq	-24(%rbp), %rax
	movq	16(%rax), %rax
	movq	%rax, %rsi
	movl	$.LC17, %edi
	movl	$0, %eax
	call	printf
	leaq	-52(%rbp), %rax
	movq	%rax, %rsi
	movl	$.LC18, %edi
	movl	$0, %eax
	call	__isoc99_scanf
	movq	-24(%rbp), %rax
	movq	32(%rax), %rax
	movq	%rax, %rsi
	movl	$.LC17, %edi
	movl	$0, %eax
	call	printf
	leaq	-48(%rbp), %rax
	movq	%rax, %rsi
	movl	$.LC18, %edi
	movl	$0, %eax
	call	__isoc99_scanf
	movq	-24(%rbp), %rax
	movq	48(%rax), %rax
	movq	%rax, %rsi
	movl	$.LC17, %edi
	movl	$0, %eax
	call	printf
	leaq	-44(%rbp), %rax
	movq	%rax, %rsi
	movl	$.LC18, %edi
	movl	$0, %eax
	call	__isoc99_scanf
	movq	-24(%rbp), %rax
	movq	64(%rax), %rax
	movq	%rax, %rsi
	movl	$.LC17, %edi
	movl	$0, %eax
	call	printf
	leaq	-40(%rbp), %rax
	movq	%rax, %rsi
	movl	$.LC18, %edi
	movl	$0, %eax
	call	__isoc99_scanf
	movl	$.LC19, %edi
	call	puts
	movss	-56(%rbp), %xmm0
	unpcklps	%xmm0, %xmm0
	cvtps2pd	%xmm0, %xmm0
	call	floor
	movsd	%xmm0, -72(%rbp)
	movq	-72(%rbp), %rax
	movq	-24(%rbp), %rdx
	movq	(%rdx), %rdx
	movq	%rax, -72(%rbp)
	movsd	-72(%rbp), %xmm0
	movq	%rdx, %rsi
	movl	$.LC20, %edi
	movl	$1, %eax
	call	printf
	movss	-52(%rbp), %xmm0
	unpcklps	%xmm0, %xmm0
	cvtps2pd	%xmm0, %xmm0
	call	floor
	movsd	%xmm0, -72(%rbp)
	movq	-72(%rbp), %rax
	movq	-24(%rbp), %rdx
	movq	16(%rdx), %rdx
	movq	%rax, -72(%rbp)
	movsd	-72(%rbp), %xmm0
	movq	%rdx, %rsi
	movl	$.LC20, %edi
	movl	$1, %eax
	call	printf
	movss	-48(%rbp), %xmm0
	unpcklps	%xmm0, %xmm0
	cvtps2pd	%xmm0, %xmm0
	call	floor
	movsd	%xmm0, -72(%rbp)
	movq	-72(%rbp), %rax
	movq	-24(%rbp), %rdx
	movq	32(%rdx), %rdx
	movq	%rax, -72(%rbp)
	movsd	-72(%rbp), %xmm0
	movq	%rdx, %rsi
	movl	$.LC20, %edi
	movl	$1, %eax
	call	printf
	movss	-44(%rbp), %xmm0
	unpcklps	%xmm0, %xmm0
	cvtps2pd	%xmm0, %xmm0
	call	floor
	movsd	%xmm0, -72(%rbp)
	movq	-72(%rbp), %rax
	movq	-24(%rbp), %rdx
	movq	48(%rdx), %rdx
	movq	%rax, -72(%rbp)
	movsd	-72(%rbp), %xmm0
	movq	%rdx, %rsi
	movl	$.LC20, %edi
	movl	$1, %eax
	call	printf
	movss	-40(%rbp), %xmm0
	unpcklps	%xmm0, %xmm0
	cvtps2pd	%xmm0, %xmm0
	call	floor
	movsd	%xmm0, -72(%rbp)
	movq	-72(%rbp), %rax
	movq	-24(%rbp), %rdx
	movq	64(%rdx), %rdx
	movq	%rax, -72(%rbp)
	movsd	-72(%rbp), %xmm0
	movq	%rdx, %rsi
	movl	$.LC20, %edi
	movl	$1, %eax
	call	printf
.L9:
	movl	$0, %eax
	movq	%rbx, %rsp
	movq	-8(%rbp), %rbx
	leave
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE3:
	.size	main, .-main
	.ident	"GCC: (Ubuntu 4.8.4-2ubuntu1~14.04.4) 4.8.4"
	.section	.note.GNU-stack,"",@progbits
