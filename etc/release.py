#!env python

# Script for releasing Kunagi

import sys
import os
import shutil

def fail(message):
    print message
    print ''
    print '*** Releasing Kunagi FAILED ****'
    exit(1)

def execute(cmd, dir=None):
    previousDir = os.getcwd()
    if dir:
        os.chdir(dir)
    pipe = os.popen('{ ' + cmd + '; } 2>&1', 'r')
    text = pipe.read()
    sts = pipe.close()
    if dir:
        os.chdir(previousDir)
    if sts is None: sts = 0
    if text[-1:] == '\n': text = text[:-1]
    if sts != 0:
        fail('Executing command failed: ' + cmd + '\n' + text)
    return text

# ------------ main -----------------

# configuration
artifactsDestinationHomeDir = 'build/releases' #'/var/www/kunagi.org/releases'
remoteRepository = 'git://github.com/Kunagi/kunagi.git'
repositoryDir = 'kunagi-repo'
buildDir = repositoryDir + '/build'
packageWar = buildDir + '/kunagi.war'
packageZip = buildDir + '/kunagi.zip'
packageTar = buildDir + '/kunagi.tar.bz2'

# check parameters
if len(sys.argv) < 2:
    fail('Missing parameter: release-label')

releaseLabel = sys.argv[1]
branchName = 'r' + releaseLabel
print 'Releasing Kunagi ' + releaseLabel

# cleanup previous release
print '  Clean'
#TODO

# checkout
print '  Clone git repository ' + remoteRepository + ' -> ' + repositoryDir
execute('git clone ' + remoteRepository + ' ' + repositoryDir)
print '  Checkout branch ' + branchName
execute('git checkout ' + branchName, repositoryDir)

# write build.properties file
print '  Update build.properties'
#TODO

# build
print '  Build'
execute('ant', repositoryDir)

# check files and directories
print '  Check artifacts'
artifactsDestinationDir = artifactsDestinationHomeDir + '/' + releaseLabel
if os.path.exists(artifactsDestinationDir):
    fail('Release directory already exists: ' + artifactsDestinationDir)
if not os.path.exists(packageWar):
    fail('Missing war package: ' + packageWar)
if not os.path.exists(packageZip):
    fail('Missing zip package: ' + packageZip)
if not os.path.exists(packageTar):
    fail('Missing tar package: ' + packageTar)

# copy artifacts
print '  Copy artifacts to ' + artifactsDestinationDir
os.mkdir(artifactsDestinationDir)
shutil.copyfile(packageWar, artifactsDestinationDir + '/kunagi.war')
shutil.copyfile(packageZip, artifactsDestinationDir + '/kunagi-' + releaseLabel + '.zip')
shutil.copyfile(packageTar, artifactsDestinationDir + '/kunagi-' + releaseLabel + '.tar.bz2')

# upload to sourceforge
print '  Upload artifacts to SourceForge'
sourceForgePath = 'koczewski,kunagi@frs.sourceforge.net:/home/frs/project/k/ku/kunagi/' + releaseLabel
execute('scp ' + packageWar + ' ' + sourceForgePath + '/kunagi.war')
execute('scp ' + packageZip + ' ' + sourceForgePath + '/kunagi-' + releaseLabel + '.zip')
execute('scp ' + packageTar + ' ' + sourceForgePath + '/kunagi-' + releaseLabel + '.tar.bz2')

print 'Kunagi ' + releaseLabel + ' released'
